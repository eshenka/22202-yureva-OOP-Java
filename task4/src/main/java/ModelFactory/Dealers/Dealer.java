package ModelFactory.Dealers;

import ModelFactory.Details.Car;
import ModelFactory.FactoryController;
import ModelFactory.Storages.Storage;

public class Dealer extends Thread {
    Storage<Car> carStorage;
    FactoryController controller;
    int speed;

    public Dealer(int speed, Storage<Car> carStorage, FactoryController controller) {
        this.speed = speed;
        this.carStorage = carStorage;
        this.controller = controller;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void buy() throws InterruptedException {
        sleep(speed);
        Car car = (Car) carStorage.get();
        controller.upd();
    }

    @Override
    public void run() {
        while (true) {
            try {
                buy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
