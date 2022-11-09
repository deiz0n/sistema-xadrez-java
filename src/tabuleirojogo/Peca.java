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

<<<<<<< HEAD
    public abstract boolean[][] movimentosPossiveis();

    public boolean possivelMovimento(Posicao posicao) {
        return movimentosPossiveis()[posicao.getFileira()][posicao.getColuna()];
    }

    public boolean existeAlgumMovimento() {
        boolean[][] mat = movimentosPossiveis();
        for (int i=0; i < mat.length; i++) {
            for (int x=0; x < mat.length; x++) {
=======
    public abstract boolean[][] possivelMovimento();

    public boolean possivelMovimento(Posicao posicao) {
        return possivelMovimento()[posicao.getFileira()][posicao.getColuna()];
    }

    public boolean existePossibilidadeMovimento() {
        boolean[][] mat = possivelMovimento();
        for (int i=0; i< mat.length; i++) {
            for (int x=0; x< mat.length; x++) {
>>>>>>> c21f9be80e6095336a20e3afff9e02e0b1b03aab
                if (mat[i][x]) {
                    return true;
                }
            }
        }
        return false;
    }

}
