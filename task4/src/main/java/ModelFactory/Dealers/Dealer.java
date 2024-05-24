package ModelFactory.Dealers;

import ModelFactory.Details.Car;
import ModelFactory.FactoryController;
import ModelFactory.Storages.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dealer extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Dealer.class);

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

        logger.info("Dealer bought" + " : Auto " + car.getId() + " : (Body: " + car.getBody().getId() + ", Motor " + car.getMotor().getId() + ", Accessory " + car.getAccessory().getId() + ")");
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
