package View;

import Observation.Observer;

import javax.swing.*;

public class View extends JFrame {
    GridPanel gridPanel;

    public View() {
        super("Memory Game");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }


    public void setDifficulty(int difficulty) {
        JPanel panel = new JPanel();
        panel.setSize(1000, 1000);

        gridPanel = new GridPanel(difficulty);

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
