package aplicacao;

import xadrez.Cores;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {

    // Cores disponíveis para utilização do projeto
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // Método responsável por limpar a tela
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Método responsável por ler as posições dadas pelo jogador
    public static PosicaoXadrez lerPosicaoXadrez(Scanner input) {
        try {
            String s = input.nextLine();
            char coluna = s.charAt(0);
            int fileira = Integer.parseInt(s.substring(1));
            return new PosicaoXadrez(coluna, fileira);
        }
        catch (RuntimeException e) {
            throw new InputMismatchException("Erro ao ler a posição do xadrez. Valores válidos vão de a1 à h8");
        }
    }

    // Método responsável por mostrar a partida
    public static void printPartida(PartidaXadrez partidaXadrez, List<PecaXadrez> capturadas) {
        printTabuleiro(partidaXadrez.getPecas());
        System.out.println("");
        printPecaCapturada(capturadas);
        System.out.println();
        System.out.println("Turno: " + partidaXadrez.getTurno());
        if (!partidaXadrez.getCheckMate()) {
            System.out.println("Esperando jogador: " + partidaXadrez.getJogadorAtual());
            if (partidaXadrez.getCheck()) {
                System.out.println("CHECK!");
            }
        }
        else {
            System.out.println("CHECKMATE!");
            System.out.println("Vencedor: " + partidaXadrez.getJogadorAtual());
        }
    }

    // Método responsável por printar o tabuleiro
    public static void printTabuleiro(PecaXadrez[][] pecas) {
        for (int i=0; i < pecas.length; i++) {
            System.out.print(8-i + " ");
            for (int z=0; z < pecas.length; z++ ) {
                printPeca(pecas[i][z], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    // Método responsável por printar o tabuleiro com os possíveis movimentos de determinada peça
    public static void printTabuleiro(PecaXadrez[][] pecas, boolean[][] movimentosPossiveis) {
        for (int i=0; i < pecas.length; i++) {
            System.out.print(8-i + " ");
            for (int z=0; z < pecas.length; z++ ) {
                printPeca(pecas[i][z], movimentosPossiveis[i][z]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    // Método responsável pela representação das peças no tabuleiro
    private static void printPeca(PecaXadrez pecas, boolean background) {
        if (background) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (pecas == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (pecas.getCores() == Cores.BRANCO) {
                System.out.print(ANSI_WHITE + pecas + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + pecas + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    // Método resposável por mostar as peças capturadas
    private static void printPecaCapturada(List<PecaXadrez> capturadas) {
        List<PecaXadrez> branco = capturadas.stream().filter(x -> x.getCores() == Cores.BRANCO).collect(Collectors.toList());
        List<PecaXadrez> preto = capturadas.stream().filter(x -> x.getCores() == Cores.PRETO).collect(Collectors.toList());
        System.out.println("Peças capturadas:");
        System.out.print("Branco: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString(branco.toArray()));
        System.out.print(ANSI_RESET);

        System.out.print("Preto: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.toString(preto.toArray()));
        System.out.print(ANSI_RESET);
    }

}
