package ModelFactory;

import ModelFactory.Details.*;
import ModelFactory.Storages.Storage;
import ModelFactory.Threadpool.Threadpool;
import View.Observer.Observable;

public class FactoryController extends Observable {
    Storage<Car> carStorage;
    Threadpool workersTasks;
    Storage<Detail> accessoryStorage;
    Storage <Detail> bodyStorage;
    Storage<Detail> motorStorage;

    private int criticalValue = 10;

    public FactoryController(Threadpool workersTasks) {
        this.workersTasks = workersTasks;
    }

    public void addStorages(Storage<Car> carStorage, Storage<Detail> accessoryStorage, Storage<Detail> bodyStorage, Storage<Detail> motorStorage) {
        this.carStorage = carStorage;
        this.accessoryStorage = accessoryStorage;
        this.bodyStorage = bodyStorage;
        this.motorStorage = motorStorage;
    }

    public void upd() {
        if (carStorage.getCurrentSize() <= criticalValue) {
            workersTasks.addTasks(criticalValue, accessoryStorage, bodyStorage, motorStorage, carStorage);
        }
    }
}
