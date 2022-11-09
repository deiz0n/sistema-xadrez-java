package xadrez.xadrez.pecas;

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

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getFileiras()][getTabuleiro().getColunas()];
        return mat;
    }
}
