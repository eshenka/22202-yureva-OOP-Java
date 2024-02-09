import java.util.Scanner;

public class User {
    int input_number;
    public User() {
        System.out.println("Hello! Welcome to my new game: Bulls and Cows!\n");
    }

    public void inputNumber() {
        System.out.println("Please, make a guess");

        Scanner scanner = new Scanner(System.in);

        input_number = scanner.nextInt();
    }

    public int getInputNumber() {
        return input_number;
    }
}
