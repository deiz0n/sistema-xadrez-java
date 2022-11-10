package xadrez;

import tabuleirojogo.Peca;
import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.xadrez.pecas.Rei;
import xadrez.xadrez.pecas.Torre;

public class PartidaXadrez {

    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8 ,8);
        setupInicial();
    }

    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getFileiras()][tabuleiro.getColunas()];
        for (int i=0 ; i<tabuleiro.getFileiras(); i++) {
            for (int z=0; z< tabuleiro.getColunas(); z++) {
                mat[i][z] = (PecaXadrez) tabuleiro.peca(i, z);
            }
        }
        return mat;
    }

    public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoInicial) {
        Posicao posicao = posicaoInicial.toPosicao();
        validarPosicaoInicial(posicao);
        return tabuleiro.peca(posicao).movimentosPossiveis();
    }

    public PecaXadrez moverPecaXadrez(PosicaoXadrez posicaoInicial, PosicaoXadrez posicaoPosterior) {
        Posicao inicial = posicaoInicial.toPosicao();
        Posicao posterior = posicaoPosterior.toPosicao();
        validarPosicaoInicial(inicial);
        validarPosicaoPosterior(inicial, posterior);
        Peca capturarPeca = movimento(inicial, posterior);
        return (PecaXadrez) capturarPeca;
    }

    private Peca movimento(Posicao inicial, Posicao posterior) {
        Peca p = tabuleiro.removerPeca(inicial);
        Peca capturarPcea = tabuleiro.removerPeca(posterior);
        tabuleiro.colocarPeca(p, posterior);
        return  capturarPcea;
    }

    private void validarPosicaoInicial(Posicao posicao) {
        if (!tabuleiro.haPeca(posicao)) {
            throw new XadrezException("Não existe peça na posição de origem");
        }
        if (!tabuleiro.peca(posicao).existeAlgumMovimento()) {
            throw new XadrezException("Não existe movimentos possíveis para a peça selecionada");
        }
    }

    private void validarPosicaoPosterior(Posicao inicial, Posicao posterior) {
        if (!tabuleiro.peca(inicial).possivelMovimento(posterior)) {
            throw new XadrezException("A peça escolhida não pode ser movida para a posição desejada");
        }
    }

    private  void colocarNovaPeca( char coluna, int fileira, PecaXadrez pecaXadrez) {
        tabuleiro.colocarPeca(pecaXadrez, new PosicaoXadrez(coluna, fileira).toPosicao());
    }

    private void setupInicial() {

        colocarNovaPeca('c', 1, new Torre(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('c', 2, new Torre(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('d', 2, new Torre(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('e', 2, new Torre(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('e', 1, new Torre(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('d', 1, new Rei(tabuleiro, Cores.BRANCO));

        colocarNovaPeca('c', 7, new Torre(tabuleiro, Cores.PRETO));
        colocarNovaPeca('c', 8, new Torre(tabuleiro, Cores.PRETO));
        colocarNovaPeca('d', 7, new Torre(tabuleiro, Cores.PRETO));
        colocarNovaPeca('e', 7, new Torre(tabuleiro, Cores.PRETO));
        colocarNovaPeca('e', 8, new Torre(tabuleiro, Cores.PRETO));
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Cores.PRETO));

    }

}
