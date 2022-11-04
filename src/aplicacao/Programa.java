package aplicacao;


import tabuleirojogo.Posicao;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        PartidaXadrez pat = new PartidaXadrez();

        while (true) {
            UI.printTabuleiro(pat.getPecas());
            System.out.println("");
            System.out.println("Inicial: ");
            PosicaoXadrez inicial = UI.lerPosicaoXadrez(input);

            System.out.println("");
            System.out.println("Posterior: ");
            PosicaoXadrez posteior = UI.lerPosicaoXadrez(input);

            PecaXadrez capturarPeca = pat.moverPecaXadrez(inicial, posteior);
        }


    }

}
