package xadrez;

import tabuleirojogo.Peca;
import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;

public abstract class PecaXadrez extends Peca {
<<<<<<< HEAD

=======
>>>>>>> c21f9be80e6095336a20e3afff9e02e0b1b03aab
    private Cores cores;

    public PecaXadrez(Tabuleiro tabuleiro, Cores cores) {
       super(tabuleiro);
       this.cores = cores;
    }

    public Cores getCores() {
        return cores;
    }
<<<<<<< HEAD

    protected boolean haPecaOponente(Posicao posicao) {
       PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
       return p != null && p.getCores() != cores;
=======
    protected boolean haPecaOponente(Posicao posicao) {
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p != null && p.getCores() != cores;
>>>>>>> c21f9be80e6095336a20e3afff9e02e0b1b03aab
    }

}
