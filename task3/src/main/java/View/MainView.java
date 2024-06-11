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

        JPanel mainPanel = new JPanel();
        mainPanel.setSize(600, 600);
        mainPanel.setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setSize(500, 500);

        GridLayout layout = new GridLayout(3, 1);
        layout.setHgap(100);
        panel.setLayout(layout);

        JLabel menuText = new JLabel("Choose difficulty");
        menuText.setFont(new Font("Serif", Font.BOLD, 40));

        listener = new MenuListener();

        JButton easyButton = new JButton("Easy");
        easyButton.setName("4");

        JButton hardButton = new JButton("Hard");
        hardButton.setName("6");

        easyButton.addActionListener(listener);
        hardButton.addActionListener(listener);

        panel.add(menuText);
        panel.add(easyButton);
        panel.add(hardButton);

        mainPanel.add(panel);

        add(mainPanel);
    }

    public void addObserver(Observer observer) {
        listener.addObserver(observer);
    }
}
