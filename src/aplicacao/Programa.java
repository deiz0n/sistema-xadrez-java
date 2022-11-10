package aplicacao;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        PartidaXadrez pat = new PartidaXadrez();

        while (true) {
            try {
                UI.limparTela();
                UI.printTabuleiro(pat.getPecas());
                System.out.println("");
                System.out.print("Inicial: ");
                PosicaoXadrez inicial = UI.lerPosicaoXadrez(input);

                boolean[][] movimentosPossiveis = pat.movimentosPossiveis(inicial);
                UI.limparTela();
                UI.printTabuleiro(pat.getPecas(), movimentosPossiveis);
                System.out.println("");
                System.out.print("Posterior: ");
                PosicaoXadrez posteior = UI.lerPosicaoXadrez(input);

                PecaXadrez capturarPeca = pat.moverPecaXadrez(inicial, posteior);
            }
            catch (XadrezException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }

    }
}
