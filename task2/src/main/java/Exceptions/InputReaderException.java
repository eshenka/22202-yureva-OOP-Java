package Exceptions;

import java.io.FileNotFoundException;

public class InputReaderException extends RuntimeException {
    public InputReaderException(String message) {
        super(message);
    }
}
