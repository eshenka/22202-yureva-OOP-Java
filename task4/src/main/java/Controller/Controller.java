package Controller;

import ModelFactory.Dealers.Dealer;
import ModelFactory.Factory;
import ModelFactory.Providers.AccessoryProvider;
import ModelFactory.Providers.BodyProvider;
import ModelFactory.Providers.MotorProvider;
import View.Event.*;
import View.Observer.Observer;
import View.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public class Controller implements Observer {
    Factory factory;

    public Controller(Factory factory) {
        this.factory = factory;
    }

    public void notify(Event event) {
        if (event instanceof AccessoryProviderEvent) {
            factory.setStatistics(AccessoryProvider.class, event.changedValue);
        } else if (event instanceof BodyProviderEvent) {
            factory.setStatistics(BodyProvider.class, event.changedValue);
        } else if (event instanceof MotorProviderEvent) {
            factory.setStatistics(MotorProvider.class, event.changedValue);
        } else if (event instanceof DealerEvent) {
            factory.setStatistics(Dealer.class, event.changedValue);
        }
    }

    public String motorsStored() {
        return factory.getMotorStored().toString();
    }

    public String bodiesStored() {
        return factory.getBodyStored().toString();
    }

    public String accessoriesStored() {
        return factory.getAccessoryStored().toString();
    }

    public String carsStored() {
        return factory.getCarStored().toString();
    }

    public String carsSold() {
        return factory.getCarSold().toString();
    }

    public String carsSoldAll() {
        return factory.getCarAll().toString();
    }

}
