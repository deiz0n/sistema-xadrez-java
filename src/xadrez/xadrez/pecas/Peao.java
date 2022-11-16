package xadrez.xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cores;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {

    public Peao(Tabuleiro tabuleiro, Cores cores) {
        super(tabuleiro, cores);
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getFileiras()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0, 0);
        if (getCores() == Cores.BRANCO) {
            // Movimento para frente
            p.setValores(posicao.getFileira() - 1, posicao.getColuna());
            if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
                mat[p.getFileira()][p.getColuna()] = true;
            }

            // Primeiro movimento
            p.setValores(posicao.getFileira() - 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getFileira() - 1, posicao.getColuna());
            if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p) && getTabuleiro().posicaoExistente(p2) && !getTabuleiro().haPeca(p2) && getContMovimentos() == 0) {
                mat[p.getFileira()][p.getColuna()] = true;
            }

            // Movimento para noroeste
            p.setValores(posicao.getFileira() - 1, posicao.getColuna() - 1);
            if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
                mat[p.getFileira()][p.getColuna()] = true;
            }

            // Movimento para nordeste
            p.setValores(posicao.getFileira() - 1, posicao.getColuna() + 1);
            if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
                mat[p.getFileira()][p.getColuna()] = true;
            }
        } else {
            // Movimento para frente
            p.setValores(posicao.getFileira() + 1, posicao.getColuna());
            if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
                mat[p.getFileira()][p.getColuna()] = true;
            }

            // Primeiro movimento
            p.setValores(posicao.getFileira() + 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getFileira() + 1, posicao.getColuna());
            if (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p) && getTabuleiro().posicaoExistente(p2) && !getTabuleiro().haPeca(p2) && getContMovimentos() == 0) {
                mat[p.getFileira()][p.getColuna()] = true;
            }

            // Movimento para sudeste
            p.setValores(posicao.getFileira() + 1, posicao.getColuna() - 1);
            if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
                mat[p.getFileira()][p.getColuna()] = true;
            }

            // Movimento para sudoeste
            p.setValores(posicao.getFileira() + 1, posicao.getColuna() + 1);
            if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
                mat[p.getFileira()][p.getColuna()] = true;
            }
        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }

}