import Model.Game;
import View.*;
import Controller.Controller;

import java.io.IOException;

public class Main {
    public enum Difficulty {
        EASY(4),
        HARD(6);
        private final int difficulty;
        Difficulty(int difficulty) {
            this.difficulty = difficulty;
        }
        public int getDifficulty() {
            return difficulty;
        }

    }



    public static void main(String[] args) throws IOException {
        Game game = new Game("src/main/resources/images.txt");

        View view = new View();

        Controller controller = new Controller(game, view);

        controller.showMenu();

    }


}
