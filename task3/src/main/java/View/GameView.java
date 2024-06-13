package View;

import Observation.Observer;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    GridPanel gridPanel;

    public GameView() {
        super("Memory Game");
        setSize(1000, 1000);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gridPanel = new GridPanel();
    }


    public void setDifficulty(int difficulty) {
        JPanel panel = new JPanel();
        panel.setSize(1000, 1000);

        gridPanel.setDifficulty(difficulty);

        panel.add(gridPanel);
        add(panel);
    }

    public void setImage(String imagePath, int dst, boolean state) {
        gridPanel.setImage(imagePath, dst, state);
    }

    public void addObserver(Observer observer) {
        gridPanel.addObserver(observer);
    }
}
