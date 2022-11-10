package xadrez.xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cores;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {


    public Rei(Tabuleiro tabuleiro, Cores cores) {
        super(tabuleiro, cores);
    }

    @Override
    public String toString() {
        return "R";
    }

    private boolean podeMover(Posicao posicao) {
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p == null || p.getCores() != getCores();
    }

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

        return mat;
    }
}

