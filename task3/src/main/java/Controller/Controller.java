package Controller;

import Observation.Observer;

import Model.Game;
import View.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Observer {
    Game game;
    View view;

    public Controller(Game game, View view) {
        this.game = game;
        game.addObserver(this);

        this.view = view;
        view.addObserver(this);
    }

    public void showMenu() {
        view.showMain();
    }

    boolean wrongGuess = false;
    ArrayList<Integer> wrongGuesses = new ArrayList<>();

    @Override
    public void notify (Event event) throws InterruptedException, IOException {
        if (event instanceof GuessClickEvent) {
            if (wrongGuess) {
                view.setImage("src/main/resources/Images/image.png", wrongGuesses.remove(0), true);
                view.setImage("src/main/resources/Images/image.png", wrongGuesses.remove(0), true);

                wrongGuess = false;
            }

            String image = game.getImage(((GuessClickEvent) event).source);

            view.setImage(image, ((GuessClickEvent) event).source, false);

            game.compare();

        } else if (event instanceof WrongGuessEvent) {

            wrongGuess = true;
            wrongGuesses.add(((WrongGuessEvent) event).firstIndex);
            wrongGuesses.add(((WrongGuessEvent) event).secondIndex);
        } else if (event instanceof MenuEvent) {
            game.setDifficulty(((MenuEvent) event).difficulty);

            view.setGameDifficulty(((MenuEvent) event).difficulty);
            view.showGame();

        } else if (event instanceof GameWonEvent) {
            view.showEnd();
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        game.reset();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    view.reset();

                    view.showMain();
                }
            }, 5000);


        }
    }
}
