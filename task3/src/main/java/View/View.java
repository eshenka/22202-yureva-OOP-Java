package View;

import Observation.Observer;

public class View {
    MainView mainView;
    GameView gameView;
    EndView endView;

    public View() {
        this.mainView = new MainView();
        this.gameView = new GameView();
        this.endView = new EndView();
    }

    public void addObserver(Observer observer) {
        mainView.addObserver(observer);
        gameView.addObserver(observer);
    }

    public void showMain() {
        mainView.setVisible(true);
        gameView.setVisible(false);
        endView.setVisible(false);
    }

    public void showGame() {
        mainView.setVisible(false);
        gameView.setVisible(true);
        endView.setVisible(false);
    }

    public void showEnd() {
        mainView.setVisible(false);
        gameView.setVisible(false);
        endView.setVisible(true);
    }

    public void setGameDifficulty(int difficulty) {
        gameView.setDifficulty(difficulty);
    }

    public void setImage(String imagePath, int dst, boolean state) {
        gameView.setImage(imagePath, dst, state);
        gameView.setImage(imagePath, dst, state);
    }

    public void reset() {
        gameView.reset();
    }
}
