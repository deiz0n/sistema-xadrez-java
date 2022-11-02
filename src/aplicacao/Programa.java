package aplicacao;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.PartidaXadrez;

public class Programa {

    public static void main(String[] args) {

        PartidaXadrez pat =new PartidaXadrez();
        UI.printTabuleiro(pat.getPecas());

    }

}
