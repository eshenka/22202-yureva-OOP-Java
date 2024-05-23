package Factory.Dealers;

import Factory.Details.Car;
import Factory.FactoryController;
import Factory.Storages.Storage;

public class Dealer extends Thread {
    Storage<Car> carStorage;
    FactoryController controller;
    int speed;

    public Dealer(int speed, Storage<Car> carStorage, FactoryController controller) {
        this.speed = speed;
        this.carStorage = carStorage;
        this.controller = controller;
    }

    public void buy() throws InterruptedException {
        sleep(speed);
        System.out.println("Dealer trying");
        Car car = (Car) carStorage.get();
        System.out.println("Dealer bought");
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
