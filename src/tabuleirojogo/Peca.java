package tabuleirojogo;

public abstract class Peca {

    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        posicao = null;
    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract boolean[][] possivelMovimento();

    public boolean possivelMovimento(Posicao posicao) {
        return possivelMovimento()[posicao.getFileira()][posicao.getColuna()];
    }

    public boolean existePossibilidadeMovimento() {
        boolean[][] mat = possivelMovimento();
        for (int i=0; i< mat.length; i++) {
            for (int x=0; x< mat.length; x++) {
                if (mat[i][x]) {
                    return true;
                }
            }
        }
        return false;
    }

}
