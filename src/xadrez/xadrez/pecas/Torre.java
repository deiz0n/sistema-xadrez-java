package xadrez.xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cores;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Cores cores) {
        super(tabuleiro, cores);
    }

    @Override
    public String toString() {
        return "T";
    }

    @Override
<<<<<<< HEAD
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getFileiras()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0, 0);

        // Movimento para cima
        p.setValores(posicao.getFileira() - 1, posicao.getColuna());
        while(getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setFileira(p.getFileira() - 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

        // Movimento para esquerda
        p.setValores(posicao.getFileira(), posicao.getColuna() - 1);
        while(getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getColuna()][p.getColuna()] = true;
        }

        // Movimento para direita
        p.setValores(posicao.getFileira(), posicao.getColuna() + 1);
        while(getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setColuna(p.getColuna() + 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getColuna()][p.getColuna()] = true;
        }

        // Movimento para baixo
        p.setValores(posicao.getFileira() + 1, posicao.getColuna());
        while(getTabuleiro().posicaoExistente(p) && !getTabuleiro().haPeca(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
            p.setFileira(p.getFileira() + 1);
        }
        if (getTabuleiro().posicaoExistente(p) && haPecaOponente(p)) {
            mat[p.getFileira()][p.getColuna()] = true;
        }

=======
    public boolean[][] possivelMovimento() {
        boolean[][] mat = new boolean[getTabuleiro().getFileiras()][getTabuleiro().getColunas()];
        Posicao x = new Posicao(0,0);

        // Movimento para cima
        x.setValores(posicao.getFileira() - 1, posicao.getColuna());
        while (getTabuleiro().posicaoExistente(x) && !getTabuleiro().haPeca(x)) {
            mat[x.getFileira()][x.getColuna()] = true;
            x.setFileira(x.getFileira() - 1);
        }
        if (getTabuleiro().posicaoExistente(posicao) && haPecaOponente(posicao)) {
            mat[x.getFileira()][x.getColuna()] = true;
        }

        // Movimento para o lado esquerdo
        x.setValores(posicao.getFileira(), posicao.getColuna() - 1);
        while (getTabuleiro().posicaoExistente(x) && !getTabuleiro().haPeca(x)) {
            mat[x.getFileira()][x.getColuna()] = true;
            x.setColuna(x.getColuna() - 1);
        }
        if (getTabuleiro().posicaoExistente(posicao) && haPecaOponente(posicao)) {
            mat[x.getFileira()][x.getColuna()] = true;
        }

        // Movimento para o lado direito
        x.setValores(posicao.getFileira(), posicao.getColuna() + 1);
        while (getTabuleiro().posicaoExistente(x) && !getTabuleiro().haPeca(x)) {
            mat[x.getFileira()][x.getColuna()] = true;
            x.setColuna(x.getColuna() + 1);
        }
        if (getTabuleiro().posicaoExistente(posicao) && haPecaOponente(posicao)) {
            mat[x.getFileira()][x.getColuna()] = true;
        }

        // Movimento para baixo
        x.setValores(posicao.getFileira() + 1, posicao.getColuna());
        while (getTabuleiro().posicaoExistente(x) && !getTabuleiro().haPeca(x)) {
            mat[x.getFileira()][x.getColuna()] = true;
            x.setFileira(x.getFileira() + 1);
        }
        if (getTabuleiro().posicaoExistente(posicao) && haPecaOponente(posicao)) {
            mat[x.getFileira()][x.getColuna()] = true;
        }
>>>>>>> c21f9be80e6095336a20e3afff9e02e0b1b03aab
        return mat;
    }
}
