package tabuleirojogo;

public class Tabuleiro {

    private int fileiras;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int fileiras, int colunas) {
        this.fileiras = fileiras;
        this.colunas = colunas;
        pecas = new Peca[fileiras][colunas];
    }

    public int getFileiras() {
        return fileiras;
    }

    public void setFileiras(int fileiras) {
        this.fileiras = fileiras;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public Peca peca(int fila, int coluna) {
        return pecas[fila][coluna];
    }

    public Peca peca(Posicao posicao) {
        return pecas[posicao.getFileira()][posicao.getColuna()];
    }

}
