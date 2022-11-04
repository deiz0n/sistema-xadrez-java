package xadrez;

import tabuleirojogo.TabuleiroException;

import java.io.Serial;

public class XadrezException extends TabuleiroException {

    @Serial
    private static final long seriaLVersionUID = 1L;

    public XadrezException(String msg) {
        super(msg);
    }


}
