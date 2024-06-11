package View.Listener;

import View.Event.MotorProviderEvent;
import View.Observer.Observable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MotorListener extends Observable implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        notify(new MotorProviderEvent(slider.getValue()));
    }
}
