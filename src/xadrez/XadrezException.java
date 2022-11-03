package xadrez;

import java.io.Serial;

public class XadrezException extends RuntimeException{

    @Serial
    private static final long seriaLVersionUID = 1L;

    public XadrezException(String msg) {
        super(msg);
    }


}
