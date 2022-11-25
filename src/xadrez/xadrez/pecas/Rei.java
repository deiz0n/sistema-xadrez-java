package xadrez.xadrez.pecas;

import tabuleirojogo.Peca;
import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cores;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

    // Variável
    private PartidaXadrez partidaXadrez;

    // Construtor
    public Rei(Tabuleiro tabuleiro, Cores cores, PartidaXadrez partidaXadrez) {
        super(tabuleiro, cores);
        this.partidaXadrez = partidaXadrez;
    }

    // Método responsável por verificar os possíveis do rei
    private boolean podeMover(Posicao posicao) {
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p == null || p.getCores() != getCores();
    }

    // Método responável por verificar se é possível realizar o Roque
    private boolean torreRoqueTeste(Posicao posicao) {
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p != null && p instanceof Torre && p.getCores() == getCores() && p.getContMovimentos() == 0;
    }

    // Método responsável por determinar os possíveis do rei no tabuleiro
    @Override
    public boolean[][] movimentosPossiveis() {

        boolean[][] mat = new boolean[getTabuleiro().getFileiras()][getTabuleiro().getColunas()];

        Posicao p = new Posicao(0, 0);

        // Movimentos para cima
        p.setValores(posicao.getFileira() - 1, posicao.getColuna());
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para esquerda
        p.setValores(posicao.getFileira(), posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para direita
        p.setValores(posicao.getFileira(), posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para baixo
        p.setValores(posicao.getFileira() + 1, posicao.getColuna());
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para noroeste
        p.setValores(posicao.getFileira() - 1, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para nordeste
        p.setValores(posicao.getFileira() - 1, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para sudoeste
        p.setValores(posicao.getFileira() + 1, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para sudeste
        p.setValores(posicao.getFileira() + 1, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento especial Roque
        if (getContMovimentos() == 0 && !partidaXadrez.getCheck()) {

            // Roque pequeno
            Posicao torre1 = new Posicao(posicao.getFileira(), posicao.getColuna() + 3);
            if (torreRoqueTeste(torre1)) {
                Posicao p1 = new Posicao(posicao.getFileira(), posicao.getColuna() + 1);
                Posicao p2 = new Posicao(posicao.getFileira(), posicao.getColuna() + 2);
                if (getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null) {
                    mat[posicao.getFileira()][posicao.getColuna() + 2] = true;
                }
            }

            // Roque grande
            Posicao torre2 = new Posicao(posicao.getFileira(), posicao.getColuna() - 4);
            if (torreRoqueTeste(torre2)) {
                Posicao p1 = new Posicao(posicao.getFileira(), posicao.getColuna() - 1);
                Posicao p2 = new Posicao(posicao.getFileira(), posicao.getColuna() - 2);
                Posicao p3 = new Posicao(posicao.getFileira(), posicao.getColuna() - 3);
                if (getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null  && getTabuleiro().peca(p3) == null){
                    mat[posicao.getFileira()][posicao.getColuna() - 2] = true;
                }
            }
        }
        return mat;
    }

    // Método responsável pela representação do rei no tabuleiro
    @Override
    public String toString() {
        return "R";
    }

}

