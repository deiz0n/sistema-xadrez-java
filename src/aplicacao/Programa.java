package aplicacao;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        PartidaXadrez pat = new PartidaXadrez();
        List<PecaXadrez> capturadas = new ArrayList<>();

        while (!pat.getCheckMate()) {
            try {
                UI.limparTela();
                UI.printPartida(pat, capturadas);
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

                if (capturarPeca != null) {
                    capturadas.add(capturarPeca);
                }
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

        UI.limparTela();
        UI.printPartida(pat, capturadas);

    }
}
