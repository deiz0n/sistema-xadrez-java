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
<<<<<<< HEAD
    public boolean[][] movimentosPossiveis() {
=======
    public boolean[][] possivelMovimento() {
>>>>>>> c21f9be80e6095336a20e3afff9e02e0b1b03aab
        boolean[][] mat = new boolean[getTabuleiro().getFileiras()][getTabuleiro().getColunas()];
        return mat;
    }
}
