package View.Listeners;

import Controller.MenuEvent;
import Observation.Observable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuListener extends Observable implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        int source = Integer.parseInt(button.getName());

        try {
            notify(new MenuEvent("Difficulty is chosen", source));
        } catch (InterruptedException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
