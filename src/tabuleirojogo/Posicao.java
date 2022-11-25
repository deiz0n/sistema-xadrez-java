package tabuleirojogo;

public class Posicao {

    // Variáveis
    private int fileira;
    private int coluna;

    // Construtor

    public Posicao(int fileira, int coluna) {
        this.fileira = fileira;
        this.coluna = coluna;
    }

    // Getters e Setters
    public int getFileira() {
        return fileira;
    }

    public void setFileira(int fileira) {
        this.fileira = fileira;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void setValores(int fileira, int coluna) {
        this.fileira = fileira;
        this.coluna = coluna;
    }

    // Retorna as posições do tabuleiro
    @Override
    public String toString() {
        return fileira + ", " + coluna;
    }

}
