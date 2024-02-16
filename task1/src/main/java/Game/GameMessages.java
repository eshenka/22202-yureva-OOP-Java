package Game;

public class GameMessages {
    public void unSuccessfulGuessMessage() {
        System.out.println("Unfortunately, your guess was wrong");
    }

    public void printBullsAndCows(int bulls, int cows) {
        System.out.println(bulls+" bulls and "+cows+" cows\n");
    }

    public void SuccessfulGuessMessage() {
        System.out.println("You are right! Congratulations!");
    }
}
