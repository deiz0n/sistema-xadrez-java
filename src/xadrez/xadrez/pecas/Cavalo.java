package xadrez.xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cores;
import xadrez.PecaXadrez;

public class Cavalo extends PecaXadrez {
    public Cavalo(Tabuleiro tabuleiro, Cores cores) {
        super(tabuleiro, cores);
    }

    private boolean podeMover(Posicao posicao) {
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p == null || p.getCores() != getCores();
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getFileiras()][getTabuleiro().getColunas()];

        Posicao p = new Posicao(0, 0);


        p.setValores(posicao.getFileira() - 1, posicao.getColuna() - 2);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }


        p.setValores(posicao.getFileira() - 2, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }


        p.setValores(posicao.getFileira() - 2, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }


        p.setValores(posicao.getFileira() - 1, posicao.getColuna() + 2);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }


        p.setValores(posicao.getFileira() + 1, posicao.getColuna() + 2);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }


        p.setValores(posicao.getFileira() + 2, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }


        p.setValores(posicao.getFileira() + 2, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }


        p.setValores(posicao.getFileira() + 1, posicao.getColuna() - 2);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }
        return mat;
    }

    @Override
    public String toString() {
        return "C";
    }
}
