package View.Listener;

import View.Event.AccessoryProviderEvent;
import View.Observer.Observable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AccessoryListener extends Observable implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        System.out.println(slider.getValue());
        notify(new AccessoryProviderEvent(slider.getValue()));
    }
}
