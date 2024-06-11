package ModelFactory.Dealers;

import ModelFactory.Details.Car;
import ModelFactory.FactoryController;
import ModelFactory.Storages.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dealer extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Dealer.class);

    Storage<Car> carStorage;
    OnCompleteDealHandler handler;
    int speed;

    public Dealer(int speed, Storage<Car> carStorage, OnCompleteDealHandler handler) {
        this.speed = speed;
        this.carStorage = carStorage;
        this.handler = handler;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void buy() throws InterruptedException {
        sleep(speed);
        Car car = (Car) carStorage.get();

        logger.info("Dealer bought" + " : Auto " + car.getId() + " : (Body: " + car.getBody().getId() + ", Motor " + car.getMotor().getId() + ", Accessory " + car.getAccessory().getId() + ")");
    }

    @Override
    public void run() {
        while (true) {
            try {
                buy();
                handler.onComplete();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
