package exceptions;

public class ChaveNaoEncontrada extends Exception {
    private static final long serialVersionUID = 1L;

    public ChaveNaoEncontrada(String message) {
        super(message);
    }

    public ChaveNaoEncontrada(String message, Throwable cause) {
        super(message, cause);
    }
}

