package ModelFactory.Threadpool;

import ModelFactory.Details.*;
import ModelFactory.Storages.Storage;

import static java.lang.Thread.sleep;

public class WorkerTask extends Task {
    Storage<Detail> detailStorage;
    Storage <Detail> bodyStorage;
    Storage<Detail> motorStorage;
    Storage<Car> carStorage;

    public WorkerTask(Storage<Detail> detailStorage, Storage<Detail> bodyStorage, Storage<Detail> motorStorage, Storage<Car> carStorage) {
        this.detailStorage = detailStorage;
        this.bodyStorage = bodyStorage;
        this.motorStorage = motorStorage;
        this.carStorage = carStorage;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
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

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
