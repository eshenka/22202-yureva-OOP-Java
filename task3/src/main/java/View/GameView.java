package View;

import Observation.Observer;
import View.Listeners.GridListener;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    GridPanel gridPanel;
    JPanel mainPanel;
    GridListener gridListener;

    public GameView() {
        super("Memory Game");
        setSize(1000, 1000);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gridListener = new GridListener();
        gridPanel = new GridPanel(gridListener);
    }

    public void reset() {
        gridPanel = new GridPanel(gridListener);
        remove(mainPanel);
    }

    public void setDifficulty(int difficulty) {
        mainPanel = new JPanel();
        mainPanel.setSize(1000, 1000);

        gridPanel.setDifficulty(difficulty);

        mainPanel.add(gridPanel);
        add(mainPanel);
    }

    public void setImage(String imagePath, int dst, boolean state) {
        gridPanel.setImage(imagePath, dst, state);
    }

    public void addObserver(Observer observer) {
        gridPanel.addObserver(observer);
    }
}
