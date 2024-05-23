package Controller;

import Factory.Details.*;
import Factory.Storages.Storage;

import static java.lang.Thread.sleep;

public class Task implements Runnable {
    Storage<Detail> detailStorage;
    Storage <Detail> bodyStorage;
    Storage<Detail> motorStorage;
    Storage<Car> carStorage;

    public Task(Storage<Detail> detailStorage, Storage<Detail> bodyStorage, Storage<Detail> motorStorage, Storage<Car> carStorage) {
        this.detailStorage = detailStorage;
        this.bodyStorage = bodyStorage;
        this.motorStorage = motorStorage;
        this.carStorage = carStorage;
    }

    @Override
    public void run() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Car car;
        try {
            car = new Car((Motor) motorStorage.get(), (Body) bodyStorage.get(), (Accessory) detailStorage.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {

            carStorage.store(car);
            System.out.println("Task done");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
