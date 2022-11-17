package xadrez;

import tabuleirojogo.Peca;
import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.xadrez.pecas.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PartidaXadrez {

    // Variáveis

    private int turno;
    private Cores jogadorAtual;
    private Tabuleiro tabuleiro;
    private boolean check;
    private boolean checkMate;
    private PecaXadrez enPassantVuneravel;

    // Listas

    private List<Peca> pecasNoTabuleiro = new ArrayList<>();
    private List<Peca> pecasCapturadas = new ArrayList<>();

    // Inicialização da partida

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8 ,8);
        turno = 1;
        jogadorAtual = Cores.BRANCO;
        setupInicial();
    }

    // Getters

    public int getTurno() {
        return turno;
    }

    public Cores getJogadorAtual() {
        return jogadorAtual;
    }

    public boolean getCheck() {
        return check;
    }

    public boolean getCheckMate() {
        return checkMate;
    }

    public PecaXadrez getEnPassantVuneravel() {
        return enPassantVuneravel;
    }


    // Método responsável pela geração do tabuleiro

    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getFileiras()][tabuleiro.getColunas()];
        for (int i=0 ; i<tabuleiro.getFileiras(); i++) {
            for (int z=0; z<tabuleiro.getColunas(); z++) {
                mat[i][z] = (PecaXadrez) tabuleiro.peca(i, z);
            }
        }
        return mat;
    }

    // Método responsável por determinar os possíveis movimentos

    public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoInicial) {
        Posicao posicao = posicaoInicial.toPosicao();
        validarPosicaoInicial(posicao);
        return tabuleiro.peca(posicao).movimentosPossiveis();
    }

    // Método responsável pela validação e realização dos movimentos

    public PecaXadrez moverPecaXadrez(PosicaoXadrez posicaoInicial, PosicaoXadrez posicaoPosterior) {
        Posicao inicial = posicaoInicial.toPosicao();
        Posicao posterior = posicaoPosterior.toPosicao();
        validarPosicaoInicial(inicial);
        validarPosicaoPosterior(inicial, posterior);
        Peca capturarPeca = movimento(inicial, posterior);

        if (checkTeste(jogadorAtual)) {
            desfazerMovimento(inicial, posterior, capturarPeca);
            throw new XadrezException("Você não pode se colocar em check");
        }

        PecaXadrez pecaMovida = (PecaXadrez)tabuleiro.peca(posterior);

        check = (checkTeste(oponente(jogadorAtual))) ? true : false;

        if (checkMateTeste(oponente(jogadorAtual))) {
            checkMate = true;
        } else {
            proximoTurno();
        }

        // Movimento especial: En Passant
        if (pecaMovida instanceof Peao && (posterior.getFileira() == inicial.getFileira() - 2 || posterior.getFileira() == inicial.getFileira() + 2)) {
            enPassantVuneravel = pecaMovida;
        } else {
            enPassantVuneravel = null;
        }

        return (PecaXadrez) capturarPeca;
    }

    // Método responsável pelos movimentos

    private Peca movimento(Posicao inicial, Posicao posterior) {
        PecaXadrez p = (PecaXadrez)tabuleiro.removerPeca(inicial);
        p.addContMovimentos();
        Peca capturarPeca = tabuleiro.removerPeca(posterior);
        tabuleiro.colocarPeca(p, posterior);

        if (capturarPeca != null) {
            pecasNoTabuleiro.remove(capturarPeca);
            pecasCapturadas.add(capturarPeca);
        }

        // Movimento especial: Roque pequeno
        if (p instanceof  Rei && posterior.getColuna() == inicial.getColuna() + 2) {
            Posicao inicialT = new Posicao(inicial.getFileira(), inicial.getColuna() + 3);
            Posicao posteriorT = new Posicao(inicial.getFileira(), inicial.getColuna() + 1);
            PecaXadrez torre = (PecaXadrez)tabuleiro.removerPeca(inicialT);
            tabuleiro.colocarPeca(torre, posteriorT);
            torre.addContMovimentos();
        }

        // Movimento especial: Roque grande
        if (p instanceof  Rei && posterior.getColuna() == inicial.getColuna() - 2) {
            Posicao inicialT = new Posicao(inicial.getFileira(), inicial.getColuna() - 4);
            Posicao posteriorT = new Posicao(inicial.getFileira(), inicial.getColuna() - 1);
            PecaXadrez torre = (PecaXadrez)tabuleiro.removerPeca(inicialT);
            tabuleiro.colocarPeca(torre, posteriorT);
            torre.addContMovimentos();
        }

        // Movimento especial: En Passant
        if (p instanceof  Peao) {
            if (inicial.getColuna() != posterior.getColuna() && capturarPeca == null) {
                Posicao posicaoPeao;
                if (p.getCores() == Cores.BRANCO) {
                    posicaoPeao = new Posicao(posterior.getFileira() + 1, posterior.getColuna());
                } else {
                    posicaoPeao = new Posicao(posterior.getFileira() - 1, posterior.getColuna());
                }
                capturarPeca = tabuleiro.removerPeca(posicaoPeao);
                pecasCapturadas.add(capturarPeca);
                pecasNoTabuleiro.remove(capturarPeca);
            }
        }

        return capturarPeca;
    }

    // Método responsável por desfazer um movimento

    private void desfazerMovimento(Posicao inicial, Posicao posterior, Peca pecaCapturada) {
        PecaXadrez p = (PecaXadrez) tabuleiro.removerPeca(posterior);
        p.remContMovimentos();
        tabuleiro.colocarPeca(p, inicial);

        if (pecaCapturada != null) {
            tabuleiro.colocarPeca(pecaCapturada, posterior);
            pecasCapturadas.remove(pecaCapturada);
            pecasNoTabuleiro.add(pecaCapturada);
        }

        // Movimento especial: Roque pequeno
        if (p instanceof  Rei && posterior.getColuna() == inicial.getColuna() + 2) {
            Posicao inicialT = new Posicao(inicial.getFileira(), inicial.getColuna() + 3);
            Posicao posteriorT = new Posicao(inicial.getFileira(), inicial.getColuna() + 1);
            PecaXadrez torre = (PecaXadrez)tabuleiro.removerPeca(posteriorT);
            tabuleiro.colocarPeca(torre, inicialT);
            torre.remContMovimentos();
        }

        // Movimento especial: Roque garnde
        if (p instanceof  Rei && posterior.getColuna() == inicial.getColuna() - 2) {
            Posicao inicialT = new Posicao(inicial.getFileira(), inicial.getColuna() - 4);
            Posicao posteriorT = new Posicao(inicial.getFileira(), inicial.getColuna() - 1);
            PecaXadrez torre = (PecaXadrez)tabuleiro.removerPeca(posteriorT);
            tabuleiro.colocarPeca(torre, inicialT);
            torre.remContMovimentos();
        }

        // Movimento especial: En Passant
        if (p instanceof  Peao) {
            if (inicial.getColuna() != posterior.getColuna() && pecaCapturada == enPassantVuneravel) {
                PecaXadrez peao = (PecaXadrez)tabuleiro.removerPeca(posterior);
                Posicao posicaoPeao;
                if (p.getCores() == Cores.BRANCO) {
                    posicaoPeao = new Posicao(3, posterior.getColuna());
                } else {
                    posicaoPeao = new Posicao(4, posterior.getColuna());
                }
                tabuleiro.colocarPeca(peao, posicaoPeao);
            }
        }
    }

    // Método responsável pela validação da posição inicial

    private void validarPosicaoInicial(Posicao posicao) {
        if (!tabuleiro.haPeca(posicao)) {
            throw new XadrezException("Não existe peça na posição de origem");
        }
        if (jogadorAtual != ((PecaXadrez)tabuleiro.peca(posicao)).getCores()) {
            throw new XadrezException("A peça escolhida não é sua");
        }
        if (!tabuleiro.peca(posicao).existeAlgumMovimento()) {
            throw new XadrezException("Não existe movimentos possíveis para a peça selecionada");
        }
    }

    // Método responsável poela validação da posição final

    private void validarPosicaoPosterior(Posicao inicial, Posicao posterior) {
        if (!tabuleiro.peca(inicial).possivelMovimento(posterior)) {
            throw new XadrezException("A peça escolhida não pode ser movida para a posição desejada");
        }
    }

    // Método responsável pela contagem dos turnos

    private void proximoTurno() {
        turno++;
        jogadorAtual = (jogadorAtual == Cores.BRANCO) ? Cores.PRETO : Cores.BRANCO;
    }

    // Método reponsável por definir o oponente

    private Cores oponente(Cores cor) {
        return (cor == Cores.BRANCO) ? Cores.PRETO : Cores.BRANCO;
    }

    // Método responsável por verificar se há reis no tabuleiro

    private PecaXadrez rei(Cores cor) {
        List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCores() == cor).collect(Collectors.toList());
        for (Peca p : list) {
            if (p instanceof  Rei) {
                return (PecaXadrez)p;
            }
        }
        throw new IllegalStateException("Não existe o rei " + cor + " tabuleiro");
    }

    // Método responsável por verificar se algum dos jogadores está em check

    private boolean checkTeste(Cores cor) {
        Posicao posicaoDoRei = rei(cor).getPosicaoXadrez().toPosicao();
        List<Peca> pecasOponente = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCores() == oponente(cor)).collect(Collectors.toList());
        for (Peca p : pecasOponente) {
            boolean[][] mat = p.movimentosPossiveis();
            if (mat[posicaoDoRei.getFileira()][posicaoDoRei.getColuna()]) {
                return true;
            }
        }
        return false;
    }

    // Método responsável por verificar se houve xeque-mate

    private boolean checkMateTeste(Cores cor) {
        if (!checkTeste(cor)) {
            return false;
        }
        List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez)x).getCores() == cor).collect(Collectors.toList());
        for (Peca p : list) {
            boolean[][] mat = p.movimentosPossiveis();
            for (int i=0; i<tabuleiro.getFileiras(); i++) {
                for (int z=0; z< tabuleiro.getColunas(); z++) {
                    if (mat[i][z]) {
                        Posicao inicial = ((PecaXadrez)p).getPosicaoXadrez().toPosicao();
                        Posicao posterior = new Posicao(i, z);
                        Peca pecaCapturada = movimento(inicial, posterior);
                        boolean checkTeste = checkTeste(cor);
                        desfazerMovimento(inicial, posterior, pecaCapturada);
                        if (!checkTeste) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // Método responsável pela adição de peças

    private  void colocarNovaPeca( char coluna, int fileira, PecaXadrez pecaXadrez) {
        tabuleiro.colocarPeca(pecaXadrez, new PosicaoXadrez(coluna, fileira).toPosicao());
        pecasNoTabuleiro.add(pecaXadrez);
    }

    // Peças do tabuleiro

    private void setupInicial() {

        colocarNovaPeca('a', 2, new Peao(tabuleiro, Cores.BRANCO, this));
        colocarNovaPeca('b', 2, new Peao(tabuleiro, Cores.BRANCO, this));
        colocarNovaPeca('c', 2, new Peao(tabuleiro, Cores.BRANCO, this));
        colocarNovaPeca('d', 2, new Peao(tabuleiro, Cores.BRANCO, this));
        colocarNovaPeca('e', 2, new Peao(tabuleiro, Cores.BRANCO, this));
        colocarNovaPeca('f', 2, new Peao(tabuleiro, Cores.BRANCO, this));
        colocarNovaPeca('g', 2, new Peao(tabuleiro, Cores.BRANCO, this));
        colocarNovaPeca('h', 2, new Peao(tabuleiro, Cores.BRANCO, this));
        colocarNovaPeca('a', 1, new Torre(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('c', 1, new Bispo(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('h', 1, new Torre(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('b', 1, new Cavalo(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('f', 1, new Bispo(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('g', 1, new Cavalo(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('e', 1, new Rei(tabuleiro, Cores.BRANCO, this));
        colocarNovaPeca('d', 1, new Dama(tabuleiro, Cores.BRANCO));

        colocarNovaPeca('a', 7, new Peao(tabuleiro, Cores.PRETO, this));
        colocarNovaPeca('b', 7, new Peao(tabuleiro, Cores.PRETO, this));
        colocarNovaPeca('c', 7, new Peao(tabuleiro, Cores.PRETO, this));
        colocarNovaPeca('d', 7, new Peao(tabuleiro, Cores.PRETO, this));
        colocarNovaPeca('e', 7, new Peao(tabuleiro, Cores.PRETO, this));
        colocarNovaPeca('f', 7, new Peao(tabuleiro, Cores.PRETO, this));
        colocarNovaPeca('g', 7, new Peao(tabuleiro, Cores.PRETO, this));
        colocarNovaPeca('h', 7, new Peao(tabuleiro, Cores.PRETO, this));
        colocarNovaPeca('a', 8, new Torre(tabuleiro, Cores.PRETO));
        colocarNovaPeca('c', 8, new Bispo(tabuleiro, Cores.PRETO));
        colocarNovaPeca('h', 8, new Torre(tabuleiro, Cores.PRETO));
        colocarNovaPeca('b', 8, new Cavalo(tabuleiro, Cores.PRETO));
        colocarNovaPeca('f', 8, new Bispo(tabuleiro, Cores.PRETO));
        colocarNovaPeca('g', 8, new Cavalo(tabuleiro, Cores.PRETO));
        colocarNovaPeca('e', 8, new Rei(tabuleiro, Cores.PRETO, this));
        colocarNovaPeca('d', 8, new Dama(tabuleiro, Cores.PRETO));

    }

}
