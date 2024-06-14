package View;

import View.Listeners.MenuListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    public MenuPanel(MenuListener listener) {
        super();

        setSize(500, 500);

        GridLayout layout = new GridLayout(3, 1);
        layout.setHgap(100);
        setLayout(layout);

        JLabel menuText = new JLabel("Choose difficulty");
        menuText.setFont(new Font("Serif", Font.BOLD, 40));

        JButton easyButton = new JButton("Easy");
        easyButton.setName("4");

        JButton hardButton = new JButton("Hard");
        hardButton.setName("6");

        easyButton.addActionListener(listener);
        hardButton.addActionListener(listener);

        add(menuText);
        add(easyButton);
        add(hardButton);
    }
}
