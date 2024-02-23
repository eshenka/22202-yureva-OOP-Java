package Game;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User();

        RandNumber rand = new RandNumber();

        BullsAndCows game = new BullsAndCows(rand.getNumber());

        GameMessages gameMessages = new GameMessages();

        while(true) {
            try {
                user.inputNumber();
            } catch (Exception except) {
                System.out.println(except.getMessage());
                continue;
            }

            int guess = user.getInputNumber();

            boolean result = false;
            try {
                result = game.successful(guess);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }

            if (result) {
                gameMessages.SuccessfulGuessMessage();
                break;
            }

            gameMessages.unSuccessfulGuessMessage();
            gameMessages.printBullsAndCows(game.getBulls(), game.getCows());
        }
    }
}
