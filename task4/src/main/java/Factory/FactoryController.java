package Factory;

import Factory.Details.*;
import Factory.Storages.Storage;
import Threadpool.Threadpool;

public class FactoryController {
    Storage<Car> carStorage;
    Threadpool workersTasks;
    Storage<Detail> detailStorage;
    Storage <Detail> bodyStorage;
    Storage<Detail> motorStorage;

    private int criticalValue = 10;


    public FactoryController(Storage<Car> carStorage, Threadpool workersTasks, Storage<Detail> detailStorage,
                      Storage<Detail> bodyStorage, Storage<Detail> motorStorage) {
        this.carStorage = carStorage;
        this.workersTasks = workersTasks;
        this.detailStorage = detailStorage;
        this.bodyStorage = bodyStorage;
        this.motorStorage = motorStorage;
    }

    public void upd() {
        if (carStorage.getCurrentSize() <= criticalValue) {
            workersTasks.addTasks(criticalValue, detailStorage, bodyStorage, motorStorage, carStorage);
        }
    }
}
