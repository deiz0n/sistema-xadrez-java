package xadrez.xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cores;
import xadrez.PecaXadrez;

public class Dama extends PecaXadrez {

    // Construtor
    public Dama(Tabuleiro tabuleiro, Cores cores) {
        super(tabuleiro, cores);
    }

    // Método responsável por determinar os possíveis movimentos da dama no tabuleiro
    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getFileiras()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0, 0);

        // Movimento para cima
        p.setValores(posicao.getFileira() - 1, posicao.getColuna());
        while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setFileira(p.getFileira() - 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para esquerda
        p.setValores(posicao.getFileira(), posicao.getColuna() - 1);
        while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para direita
        p.setValores(posicao.getFileira(), posicao.getColuna() + 1);
        while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setColuna(p.getColuna() + 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para baixo
        p.setValores(posicao.getFileira() + 1, posicao.getColuna());
        while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setFileira(p.getFileira() + 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para noroeste
        p.setValores(posicao.getFileira() - 1, posicao.getColuna() - 1);
        while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setValores(p.getFileira() - 1, p.getColuna() - 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para nordeste
        p.setValores(posicao.getFileira() - 1, posicao.getColuna() + 1);
        while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setValores(p.getFileira() - 1, p.getColuna() + 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para sudeste
        p.setValores(posicao.getFileira() + 1, posicao.getColuna() + 1);
        while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setValores(p.getFileira() + 1, p.getColuna() + 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para sudoeste
        p.setValores(posicao.getFileira() + 1, posicao.getColuna() - 1);
        while (getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setValores(p.getFileira() + 1, p.getColuna() - 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }
        return mat;
    }

    // Método responsável pela representação da dama no tabuleiro
    @Override
    public String toString() {
        return "D";
    }
}
