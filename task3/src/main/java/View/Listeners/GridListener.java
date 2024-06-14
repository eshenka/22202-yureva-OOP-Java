package View.Listeners;

import Observation.Observable;

import Controller.GuessClickEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GridListener extends Observable implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        int source = Integer.parseInt(button.getName());

        try {
            notify(new GuessClickEvent("Click", source));
        } catch (InterruptedException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
