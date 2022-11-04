package xadrez;

import tabuleirojogo.Posicao;

public class PosicaoXadrez {

    private char coluna;
    private int fiileira;

    public PosicaoXadrez(char coluna, int fiileira) {
        if (coluna < 'a' || coluna > 'h' || fiileira < 1 || fiileira > 8) {
            throw new XadrezException("Erro ao instanciar PosicaoXadrez. Valores válidos são a1 até h8");
        }
        this.coluna = coluna;
        this.fiileira = fiileira;
    }

    public char getColuna() {
        return coluna;
    }

    public int getFiileira() {
        return fiileira;
    }

    protected Posicao toPosicao() {
        return new Posicao(8 - fiileira, coluna - 'a');
    }

    protected static PosicaoXadrez fromPosicao(Posicao posicao) {
        return new PosicaoXadrez((char)('a' - posicao.getColuna()), 8 - posicao.getFileira());
    }

    @Override
    public String toString() {
        return "" + coluna + fiileira;
    }

}
