public class Main {
    public static void main(String[] args) {
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

            if (game.successful(guess)) {
                gameMessages.SuccessfulGuessMessage();
                break;
            }

            gameMessages.unSuccessfulGuessMessage();
            gameMessages.printBullsAndCows(game.getBulls(), game.getCows());
        }
    }
}
