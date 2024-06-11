package Controller;

import Observation.Observer;

import Model.Game;
import View.*;

import java.io.IOException;
import java.util.ArrayList;

public class Controller implements Observer {
    Game game;
    View view;
    MainView mainView;
    EndView endView;

    public Controller(Game game, View view, MainView mainView, EndView endView) {
        this.game = game;
        game.addObserver(this);

        this.view = view;

        this.mainView = mainView;
        mainView.addObserver(this);
        mainView.setVisible(true);

        this.endView = endView;

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

            mainView.setVisible(false);
            view.setDifficulty(((MenuEvent) event).difficulty);
            view.addObserver(this);
            view.setVisible(true);

        } else if (event instanceof GameWonEvent) {
            view.setVisible(false);
            mainView.setVisible(false);
            endView.setVisible(true);
        }
    }
}
