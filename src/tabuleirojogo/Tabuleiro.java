package tabuleirojogo;

public class Tabuleiro {

    // Variáveis

    private int fileiras;
    private int colunas;
    private Peca[][] pecas;

    // Getters

    public int getFileiras() {
        return fileiras;
    }

    public int getColunas() {
        return colunas;
    }

    // Método responsável por validar a criação do tabuleiro

    public Tabuleiro(int fileiras, int colunas) {
        if (fileiras <1 || colunas < 1) {
            throw new TabuleiroException("Erro ao criar tabuleiro: é necessário pelo menos uma 1 linha e 1 coluna");
        }
        this.fileiras = fileiras;
        this.colunas = colunas;
        pecas = new Peca[fileiras][colunas];
    }

    // Método responsável por verificar se a peça está numa posição válida

    public Peca peca(int fila, int coluna) {
        if (!posicaoExistente(fila, coluna)) {
            throw new TabuleiroException("Posição inexistente no tabuleiro");
        }
        return pecas[fila][coluna];
    }

    // Método responsável por verificar se a peça está numa posição existente

    public Peca peca(Posicao posicao) {
        if (!posicaoExistente(posicao)) {
            throw new TabuleiroException("Posição inexistente no tabuleiro");
        }
        return pecas[posicao.getFileira()][posicao.getColuna()];
    }

    // Método responsável por adicionar peças

    public void colocarPeca(Peca peca, Posicao posicao) {
        if (haPeca(posicao)) {
            throw new TabuleiroException("Já existe uma peça nessa posição " + posicao);
        }
        pecas[posicao.getFileira()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    // Método responsável por remover peças

    public Peca removerPeca(Posicao posicao) {
        if (!posicaoExistente(posicao)) {
            throw new TabuleiroException("Posição inexistente no tabuleiro");
        }
        if (peca(posicao) == null) {
            return null;
        }
        Peca auxiliar = peca(posicao);
        auxiliar.posicao = null;
        pecas[posicao.getFileira()][posicao.getColuna()] = null;
        return auxiliar;
    }

    // Método responsável por verificar se a posição é válida

    private boolean posicaoExistente(int fileira, int coluna) {
        return fileira >= 0 && fileira < fileiras && coluna >= 0 && coluna < colunas;
    }

    // Método responsável por retornar a posição existente

    public boolean posicaoExistente(Posicao posicao) {
        return posicaoExistente(posicao.getFileira(), posicao.getColuna());
    }

    // Método responsável por verificar se há alguma peça em tal posição

    public boolean haPeca(Posicao posicao) {
        if (!posicaoExistente(posicao)) {
            throw new TabuleiroException("Posição inexistente no tabuleiro");
        }
        return peca(posicao) != null;
    }

}
