package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReader {
    Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public InputReader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        scanner = new Scanner(file);
    }

    public String read() {
        if (scanner.hasNextLine()) {
            return this.scanner.nextLine();
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        return scanner.hasNextLine();
    }

}
