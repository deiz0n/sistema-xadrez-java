package tabuleirojogo;

public class Tabuleiro {

    private int fileiras;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int fileiras, int colunas) {
        if (fileiras <1 || colunas < 1) {
            throw new TabuleiroException("Erro ao criar tabuleiro: é necessário pelo menos uma 1 linha e 1 coluna");
        }
        this.fileiras = fileiras;
        this.colunas = colunas;
        pecas = new Peca[fileiras][colunas];
    }

    public int getFileiras() {
        return fileiras;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca peca(int fila, int coluna) {
        if (!posicaoExistente(fila, coluna)) {
            throw new TabuleiroException("Posição inexistente no tabuleiro");
        }
        return pecas[fila][coluna];
    }

    public Peca peca(Posicao posicao) {
        if (!posicaoExistente(posicao)) {
            throw new TabuleiroException("Posição inexistente no tabuleiro");
        }
        return pecas[posicao.getFileira()][posicao.getColuna()];
    }

    public void colocarPeca(Peca peca, Posicao posicao) {
        if (haPeca(posicao)) {
            throw new TabuleiroException("Já existe uma peça nessa posição " + posicao);
        }
        pecas[posicao.getFileira()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    private boolean posicaoExistente(int fileira, int coluna) {
        return fileira >= 0 && fileira < fileiras && coluna >= 0 && coluna < colunas;
    }

    public boolean posicaoExistente(Posicao posicao) {
        return posicaoExistente(posicao.getFileira(), posicao.getColuna());
    }

    public boolean haPeca(Posicao posicao) {
        if (!posicaoExistente(posicao)) {
            throw new TabuleiroException("Posição inexistente no tabuleiro");
        }
        return peca(posicao) != null;
    }

}
