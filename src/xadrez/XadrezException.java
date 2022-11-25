package xadrez;

import tabuleirojogo.TabuleiroException;

// Exceção personalizada

public class XadrezException extends TabuleiroException {

    private static final long seriaLVersionUID = 1L;

    public XadrezException(String msg) {
        super(msg);
    }

}
