package View;

import javax.swing.*;
import java.awt.*;

public class EndView extends JFrame {

    public EndView() {
        super("Memory Game");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel endPanel = new JPanel();
        endPanel.setLayout(new GridBagLayout());

        JLabel congratsText = new JLabel("YOU WON!!!!", SwingConstants.CENTER);
        congratsText.setFont(new Font("Serif", Font.BOLD, 100));
        add(congratsText);
    }
}
