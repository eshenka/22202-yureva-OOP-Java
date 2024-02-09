public class Main {
    public static void main(String[] args) {
        User user = new User();

        RandNumber rand = new RandNumber(1000, 9999);
        BullsAndCows game = new BullsAndCows(rand.getNumber());

        GameMessages gameMessages = new GameMessages();

        while(true) {
            user.inputNumber();

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
