package tabuleirojogo;

public abstract class Peca {

    // Variáveis
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    // Construtor
    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        posicao = null;
    }

    // Getter
    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    // Método genérico para definir os movimentos das peças
    public abstract boolean[][] movimentosPossiveis();

    // Método responsável por retornar a posição dos possíveis movimentos
    public boolean possivelMovimento(Posicao posicao) {
        return movimentosPossiveis()[posicao.getFileira()][posicao.getColuna()];
    }

    // Método responsável por verificar a possibilidade de movimentos da peça
    public boolean existeAlgumMovimento() {
        boolean[][] mat = movimentosPossiveis();
        for (int i = 0; i < mat.length; i++) {
            for (int x = 0; x < mat.length; x++) {
                if (mat[i][x]) {
                    return true;
                }
            }
        }
        return false;
    }
}
