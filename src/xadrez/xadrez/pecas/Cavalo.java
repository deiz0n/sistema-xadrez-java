package xadrez.xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cores;
import xadrez.PecaXadrez;

public class Cavalo extends PecaXadrez {

    // Construtor
    public Cavalo(Tabuleiro tabuleiro, Cores cores) {
        super(tabuleiro, cores);
    }

    // Método responsável por verificar se é possível realizar o movimento dos cavalos
    private boolean podeMover(Posicao posicao) {
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p == null || p.getCores() != getCores();
    }

    // Método responsável por determinar os movimentos dos cavalos no tabuleiro
    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getFileiras()][getTabuleiro().getColunas()];

        Posicao p = new Posicao(0, 0);

        // Movimeno para oés-noroeste
        p.setValores(posicao.getFileira() - 1, posicao.getColuna() - 2);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para nor-noroeste
        p.setValores(posicao.getFileira() - 2, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para nor-nordeste
        p.setValores(posicao.getFileira() - 2, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para lés-nordeste
        p.setValores(posicao.getFileira() - 1, posicao.getColuna() + 2);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para lés-sudeste
        p.setValores(posicao.getFileira() + 1, posicao.getColuna() + 2);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para sul-sudeste
        p.setValores(posicao.getFileira() + 2, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para sul-sudoeste
        p.setValores(posicao.getFileira() + 2, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para nor-noroeste
        p.setValores(posicao.getFileira() + 1, posicao.getColuna() - 2);
        if (getTabuleiro().posicaoExistente(p) && podeMover(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }
        return mat;
    }

    // Método responsável pela representação dos cavalos no tabuleiro
    @Override
    public String toString() {
        return "C";
    }
}
