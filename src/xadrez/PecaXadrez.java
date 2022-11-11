package xadrez;

import tabuleirojogo.Peca;
import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;

public abstract class PecaXadrez extends Peca {

    // Variáveis

    private Cores cores;
    private int contMovimentos;

    // Construtor

    public PecaXadrez(Tabuleiro tabuleiro, Cores cores) {
       super(tabuleiro);
       this.cores = cores;
    }

    // Getters

    public Cores getCores() {
        return cores;
    }

    public PosicaoXadrez getPosicaoXadrez() {
        return  PosicaoXadrez.fromPosicao(posicao);
    }

    public int getContMovimentos() {
        return contMovimentos;
    }

    // Método responsável por aumentar o número de movimentos

    public void addContMovimentos() {
        contMovimentos++;
    }

    // Método responsável por diminuir o número de movimentos

    public void remContMovimentos() {
        contMovimentos--;
    }

    // Verifica se há alguma peça do oponente em tal posição

    protected boolean haPecaOponente(Posicao posicao) {
       PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
       return p != null && p.getCores() != cores;
    }

}
