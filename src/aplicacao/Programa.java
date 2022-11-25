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

        // Objetos e lista
        Scanner input = new Scanner(System.in);
        PartidaXadrez pat = new PartidaXadrez();
        List<PecaXadrez> capturadas = new ArrayList<>();

        // Laço responsável por printar a partida e o layout
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

                // Adiciona uma peça à lista de peças capturadas
                if (capturarPeca != null) {
                    capturadas.add(capturarPeca);
                }

                // Aplica a promoção
                if (pat.getPromocao() != null) {
                    System.out.print("Digite a peca para promoção (D/T/B/C): ");
                    String tipo = input.nextLine().toUpperCase();
                    while (!tipo.equals("D") && !tipo.equals("T") && !tipo.equals("B") && !tipo.equals("C")) {
                        System.out.print("Valor inválido!Digite a peça para promoção (D/T/B/C): ");
                        tipo = input.nextLine().toUpperCase();
                    }
                    pat.colocarNovaPeca(tipo);
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

        // Rretira os possíveis movimentos de uma peça após a realização de um movimento
        UI.limparTela();
        UI.printPartida(pat, capturadas);

    }
}
