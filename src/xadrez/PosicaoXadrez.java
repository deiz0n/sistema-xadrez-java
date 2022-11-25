package xadrez;

import tabuleirojogo.Posicao;

public class PosicaoXadrez {

    // Variáveis
    private char coluna;
    private int fiileira;

    // Getters
    public char getColuna() {
        return coluna;
    }

    public int getFiileira() {
        return fiileira;
    }

    // Método responsável por verificar se o jogador escolheu uma posição válida
    public PosicaoXadrez(char coluna, int fiileira) {
        if (coluna < 'a' || coluna > 'h' || fiileira < 1 || fiileira > 8) {
            throw new XadrezException("Erro ao instanciar PosicaoXadrez. Valores válidos são a1 até h8");
        }
        this.coluna = coluna;
        this.fiileira = fiileira;
    }

    // Método responsável por converter as posições do xadrez (a, 1) para as posições das matrizes (0,0)
    protected Posicao toPosicao() {
        return new Posicao(8 - fiileira, coluna - 'a');
    }

    // Método responsável por retornar as posições convertidas
    protected static PosicaoXadrez fromPosicao(Posicao posicao) {
        return new PosicaoXadrez((char)('a' + posicao.getColuna()), 8 - posicao.getFileira());
    }

    // Método responsável por retornar as posições do xadrez
    @Override
    public String toString() {
        return "" + coluna + fiileira;
    }

}
