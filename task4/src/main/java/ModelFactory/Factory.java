package ModelFactory;

import ModelFactory.Dealers.Dealer;
import ModelFactory.Dealers.OnCompleteDealHandler;
import ModelFactory.Details.Car;
import ModelFactory.Details.Detail;
import ModelFactory.Providers.*;
import ModelFactory.Storages.Storage;
import ModelFactory.Threadpool.Threadpool;
import ModelFactory.Threadpool.WorkerTask;
import View.Observer.Observer;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Factory {
    static int providersInitialSpeed = 1000;
    static int dealersInitialSpeed = 1000;

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

        carStorage = new Storage<>(carStorageSize);
        motorStorage = new Storage<>(motorStorageSize);
        bodyStorage = new Storage<>(bodyStorageSize);
        accessoryStorage = new Storage<>(accessoryStorageSize);

        factoryController.addStorages(carStorage, accessoryStorage, bodyStorage, motorStorage);

        OnCompleteProvisionHandler provisionHandler = new OnCompleteProvisionHandler(factoryController);

        // Creating providers
        motorProvider = new MotorProvider(providersInitialSpeed, motorStorage, provisionHandler);
        bodyProvider = new BodyProvider(providersInitialSpeed, bodyStorage, provisionHandler);

        accessoryProviders = new Provider[Integer.parseInt(properties.getProperty("AccessoryProviders"))];
        for (int i = 0; i < accessoryProviders.length; i++) {
            accessoryProviders[i] = new AccessoryProvider(providersInitialSpeed, accessoryStorage, provisionHandler);
        }

        OnCompleteDealHandler dealHandler = new OnCompleteDealHandler(factoryController);

        dealers = new Dealer[Integer.parseInt(properties.getProperty("DealersNumber"))];
        for (int i = 0; i < dealers.length; i++) {
            dealers[i] = new Dealer(dealersInitialSpeed, carStorage, dealHandler);
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

        for (int i = 0; i < 500; i ++) {
            pool.addTask(new WorkerTask(accessoryStorage, bodyStorage, motorStorage, carStorage));
        }

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
