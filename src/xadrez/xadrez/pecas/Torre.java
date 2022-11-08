package xadrez.xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cores;
import xadrez.PecaXadrez;

import java.security.PublicKey;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Cores cores) {
        super(tabuleiro, cores);
    }

    @Override
    public String toString() {
        return "T";
    }

    @Override
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
        return mat;
    }
}
