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

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Factory {
    static int providersInitialSpeed = 10000;
    static int dealersInitialSpeed = 10000;

    Storage<Car> carStorage;
    Storage<Detail> motorStorage;
    Storage<Detail> bodyStorage;
    Storage<Detail> accessoryStorage;

    // Creating providers
    Provider motorProvider;
    Provider bodyProvider;
    Provider[] accessoryProviders;


    Threadpool pool;

    FactoryController factoryController;

    Dealer[] dealers;

    public Factory() {
        File config = new File("src/main/resources/factory.cfg");
        Properties properties = new Properties();

        try {
            properties.load(new FileReader(config));
        } catch (Exception e) {
            e.printStackTrace();
        }

        pool = new Threadpool(Integer.parseInt(properties.getProperty("WorkersNumber")));

        factoryController = new FactoryController(pool);

        int carStorageSize = Integer.parseInt(properties.getProperty("CarCapacity"));
        int accessoryStorageSize = Integer.parseInt(properties.getProperty("AccessoryCapacity"));
        int bodyStorageSize = Integer.parseInt(properties.getProperty("BodyCapacity"));
        int motorStorageSize = Integer.parseInt(properties.getProperty("MotorCapacity"));

        carStorage = new Storage<>(carStorageSize, factoryController);
        motorStorage = new Storage<>(motorStorageSize, factoryController);
        bodyStorage = new Storage<>(bodyStorageSize, factoryController);
        accessoryStorage = new Storage<>(accessoryStorageSize, factoryController);

        factoryController.addStorages(carStorage, accessoryStorage, bodyStorage, motorStorage);

        // Creating providers
        motorProvider = new MotorProvider(providersInitialSpeed, motorStorage);
        bodyProvider = new BodyProvider(providersInitialSpeed, bodyStorage);

        accessoryProviders = new Provider[Integer.parseInt(properties.getProperty("AccessoryProviders"))];
        for (int i = 0; i < accessoryProviders.length; i++) {
            accessoryProviders[i] = new AccessoryProvider(providersInitialSpeed, accessoryStorage);
        }

        dealers = new Dealer[Integer.parseInt(properties.getProperty("DealersNumber"))];
        for (int i = 0; i < dealers.length; i++) {
            dealers[i] = new Dealer(dealersInitialSpeed, carStorage, factoryController);
        }

    }


    public void start() {
        motorProvider.start();
        bodyProvider.start();

        for (Provider provider : accessoryProviders) {
            provider.start();
        }

        for (Dealer dealer : dealers) {
            dealer.start();
        }

        pool.addTasks(500, accessoryStorage, bodyStorage, motorStorage, carStorage);
        pool.run();

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
            for (Provider provider : accessoryProviders) {
                provider.setSpeed(speed);
            }
        } else if (className == Dealer.class) {
            for (Dealer dealer : dealers) {
                dealer.setSpeed(speed);
            }
        }
    }

}