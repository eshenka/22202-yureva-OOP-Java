package io;

import Exceptions.EmptyInputException;
import Exceptions.InputReaderException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReader {
    Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public InputReader(String fileName) {
        File file;
        try {
            file = new File(fileName);
            scanner = new Scanner(file);
        } catch (InputReaderException | FileNotFoundException exception) {
            throw new InputReaderException("Unable to open file");
        }
    }

    public String read() {
        if (scanner.hasNextLine()) {
            try {
                String line = this.scanner.nextLine();

                if (line.isEmpty()) {
                    throw new EmptyInputException("Input is empty");
                } else {
                    return line;
                }
            } catch (EmptyInputException exception) {
                System.err.println(exception.getMessage());
            }
        }
        return null;
    }

    public boolean hasNext() {
        return scanner.hasNextLine();
    }
}
