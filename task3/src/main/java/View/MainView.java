package View;

import Observation.Observer;
import View.Listeners.MenuListener;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    MenuListener listener;

    public MainView() {
        super("Memory Game");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        listener = new MenuListener();

        JPanel mainPanel = new JPanel();
        mainPanel.setSize(600, 600);
        mainPanel.setLayout(new GridBagLayout());

        JPanel panel = new MenuPanel(listener);

        mainPanel.add(panel);

        add(mainPanel);
    }

    public void addObserver(Observer observer) {
        listener.addObserver(observer);
    }
}
