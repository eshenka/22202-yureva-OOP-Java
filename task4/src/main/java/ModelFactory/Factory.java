package ModelFactory;

import Controller.Controller;
import ModelFactory.Dealers.Dealer;
import ModelFactory.Details.Car;
import ModelFactory.Details.Detail;
import ModelFactory.Providers.AccessoryProvider;
import ModelFactory.Providers.BodyProvider;
import ModelFactory.Providers.MotorProvider;
import ModelFactory.Providers.Provider;
import ModelFactory.Storages.Storage;
import ModelFactory.Threadpool.Threadpool;
import View.Observer.Observer;

public class Factory {

    Storage<Car> carStorage;
    Storage<Detail> motorStorage;
    Storage<Detail> bodyStorage;
    Storage<Detail> accessoryStorage;

    // Creating providers
    Provider motorProvider;
    Provider bodyProvider;
    Provider accessoryProvider;


    Threadpool pool;

    FactoryController factoryController;

    Dealer dealer;
    Dealer dealer2;

    public Factory() {
        pool = new Threadpool(20);

        factoryController = new FactoryController(pool);

        carStorage = new Storage<>(150, factoryController);
        motorStorage = new Storage<>(30, factoryController);
        bodyStorage = new Storage<>(30, factoryController);
        accessoryStorage = new Storage<>(30, factoryController);

        factoryController.addStorages(carStorage, accessoryStorage, bodyStorage, motorStorage);

        // Creating providers
        motorProvider = new MotorProvider(1000, motorStorage);
        bodyProvider = new BodyProvider(1000, bodyStorage);
        accessoryProvider = new AccessoryProvider(1000, accessoryStorage);




//        factoryController = new FactoryController(carStorage, pool, accessoryStorage, bodyStorage, motorStorage);

        dealer = new Dealer(5000, carStorage, factoryController);
        dealer2 = new Dealer(2000, carStorage, factoryController);
    }


    public void start() {
        motorProvider.start();
        bodyProvider.start();
        accessoryProvider.start();

        pool.addTasks(500, accessoryStorage, bodyStorage, motorStorage, carStorage);
        pool.run();

        dealer.start();
        dealer2.start();
    }

    public void getStatistics() {
        System.out.println(carStorage.getCurrentSize());
        System.out.println(carStorage.getAllStored());
        System.out.println(carStorage.getAllBought());

        System.out.println("\n");
    }

    public void subscribe(Observer observer) {
        factoryController.addObserver(observer);
    }

    public Integer getMotorStored() {
        return motorStorage.gerCurrentSize();
    }

    public Integer getBodyStored() {
        return bodyStorage.gerCurrentSize();
    }

    public Integer getAccessoryStored() {
        return accessoryStorage.gerCurrentSize();
    }

    public Integer getCarStored() {
        return carStorage.gerCurrentSize();
    }

    public Integer getCarSold() {
        return carStorage.getAllBought();
    }

    public Integer getCarAll() {
        return carStorage.getAllStored();
    }

    public void setStatistics(Class className, int speed) {
        if (className == MotorProvider.class) {
            motorProvider.setSpeed(speed);
        } else if (className == BodyProvider.class) {
            bodyProvider.setSpeed(speed);
        } else if (className == AccessoryProvider.class) {
            accessoryProvider.setSpeed(speed);
        } else if (className == Dealer.class) {
            dealer.setSpeed(speed);
        }
    }

}
