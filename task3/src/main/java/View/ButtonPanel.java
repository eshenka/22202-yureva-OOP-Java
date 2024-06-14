package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    JButton button;
    public ButtonPanel (String name, ActionListener listener) {
        button = new JButton();

        button.setIcon(new ImageIcon("src/main/resources/Images/image.png"));
        button.setName(name);
        button.setPreferredSize(new Dimension(128, 128));
        button.addActionListener(listener);

        add(button);
    }
}
