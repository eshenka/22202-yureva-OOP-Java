package View;

import Observation.Observer;
import View.Listeners.GridListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GridPanel extends JPanel {

    ArrayList<JPanel> buttonPanels;
    GridListener gridListener;
    public GridPanel (GridListener gridListener) {
        this.gridListener = gridListener;
    }

    public void setDifficulty(int difficulty) {
        setLayout(new GridLayout(difficulty, difficulty));
        setSize(500, 500);

        buttonPanels = new ArrayList<>();

        for (Integer i = 0; i < difficulty * difficulty; i++) {
            buttonPanels.add(new ButtonPanel(i.toString(), gridListener));
            add(buttonPanels.get(i));
        }
    }

    public void addObserver(Observer observer) {
        gridListener.addObserver(observer);
    }

    public void setImage(String imagePath, int source, boolean state) {
        Component[] button = buttonPanels.get(source).getComponents();

        button[0].setEnabled(state);

        ((JButton) button[0]).setDisabledIcon(new ImageIcon(imagePath));

        updateUI();
    }
}
