package Game;

import java.util.Scanner;

public class User {
    int input_number;
    public User() {
        System.out.println("Hello! Welcome to my new game: Bulls and Cows!\n");
    }

    public void inputNumber() throws Exception {
        System.out.println("Please, make a guess");

        Scanner scanner = new Scanner(System.in);

        input_number = scanner.nextInt();

        if (String.valueOf(input_number).length() != 4) {
            throw new Exception("Bad length, try again!");
        }
    }

    public int getInputNumber() {
        return input_number;
    }
}
