package xadrez;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.xadrez.pecas.Rei;
import xadrez.xadrez.pecas.Torre;

public class PartidaXadrez {

    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8 ,8);
        setupInicial();
    }

    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getFileiras()][tabuleiro.getColunas()];
        for (int i=0 ; i<tabuleiro.getFileiras(); i++) {
            for (int z=0; z< tabuleiro.getColunas(); z++) {
                mat[i][z] = (PecaXadrez) tabuleiro.peca(i, z);
            }
        }
        return mat;
    }

    private  void colocarNovaPeca( char coluna, int fileira, PecaXadrez pecaXadrez) {
        tabuleiro.colocarPeca(pecaXadrez, new PosicaoXadrez(coluna, fileira).toPosicao());
    }

    private void setupInicial() {
        colocarNovaPeca('b', 6, new Torre(tabuleiro, Cores.BRANCO));
        colocarNovaPeca('e', 8, new Rei(tabuleiro, Cores.PRETO));
        colocarNovaPeca('e', 1, new Rei(tabuleiro, Cores.BRANCO));
    }

}
