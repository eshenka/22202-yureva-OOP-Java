package View;

import Controller.Controller;
import View.Event.AccessoryProviderEvent;
import View.Event.BodyProviderEvent;
import View.Event.DealerEvent;
import View.Event.Event;
import View.Event.MotorProviderEvent;
import View.Listener.*;
import View.Observer.Observer;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener, Observer {

    AccessoryListener accessoryListener;
    BodyListener bodyListener;
    DealerListener dealerListener;
    MotorListener motorListener;
    Controller controller;

    JPanel mainPanel;

    public View(Controller controller) {
        this.controller = controller;

        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(500, 700));

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(500, 350));

        AccessoryProviderEvent accessoryProviderEvent = new AccessoryProviderEvent(0);
        BodyProviderEvent bodyProviderEvent = new BodyProviderEvent(0);
        MotorProviderEvent motorProviderEvent = new MotorProviderEvent(0);
        DealerEvent dealerEvent = new DealerEvent(0);

        accessoryListener = new AccessoryListener();
        bodyListener = new BodyListener();
        dealerListener = new DealerListener();
        motorListener = new MotorListener();

        accessoryListener.addObserver(controller);
        bodyListener.addObserver(controller);
        dealerListener.addObserver(controller);
        motorListener.addObserver(controller);

        addComponents("Motor Providers' speed", 0, 0, motorListener);
        addComponents("Body Providers' speed", 0, 10, bodyListener);
        addComponents("Accessory Providers' speed", 0, 20, accessoryListener);
        addComponents( "Dealers' speed", 0, 30, dealerListener);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setPreferredSize(new Dimension(400, 400));

        JPanel container = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 0;
        gbc.weighty = 0;
        container.add(mainPanel, gbc);

        add(container);

        setVisible(true);

    }

    private void addComponents(String name, int x, int y, ChangeListener listener) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JSlider slider = new JSlider(1, 10, 5);
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(1);
        slider.setPreferredSize(new Dimension(1, 1));
        slider.addChangeListener(listener);
        slider.setLocation(x, y);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(1);


        JLabel label = new JLabel(name);
        label.setSize(1, 1);

        panel.add(label, BorderLayout.NORTH);
        panel.add(slider, BorderLayout.CENTER);

        mainPanel.add(panel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D graphics = (Graphics2D) g;

        String motorStorageInfo = "Motors stored: " + controller.motorsStored();
        String bodyStorageInfo = "Bodies stored: " + controller.bodiesStored();
        String accessoryStorageInfo = "Accessories stored: " + controller.accessoriesStored();
        String carStorageInfo = "Cars stored: " + controller.carsStored();
        String carSoldInfo = "Cars sold: " + controller.carsSold();
        String carAllInfo = "Cars produced: " + controller.carsSoldAll();

        graphics.drawString(motorStorageInfo, getBounds().width / 2 - 50, getBounds().height - 70);
        graphics.drawString(bodyStorageInfo, getBounds().width / 2 - 50, getBounds().height - 60);
        graphics.drawString(accessoryStorageInfo, getBounds().width / 2 - 50, getBounds().height - 50);
        graphics.drawString(carStorageInfo, getBounds().width / 2 - 50, getBounds().height - 40);
        graphics.drawString(carSoldInfo, getBounds().width / 2 - 50, getBounds().height - 30);
        graphics.drawString(carAllInfo, getBounds().width / 2 - 50, getBounds().height - 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void notify(Event event) {
        repaint();
    }
}
