package aplicacao;

import xadrez.PecaXadrez;

public class UI {

    public static void printTabuleiro(PecaXadrez[][] pecas) {
        for (int i=0; i < pecas.length; i++) {
            System.out.print(8-i + " ");
            for (int z=0; z < pecas.length; z++ ) {
                printPeca(pecas[i][z]);
            }
            System.out.println("");
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPeca(PecaXadrez pecas) {
        if (pecas == null) {
            System.out.print("-");
        }
        else {
            System.out.print(pecas);
        }
        System.out.print(" ");
    }


}
