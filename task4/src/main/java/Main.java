import Factory.Dealers.Dealer;
import Factory.Details.*;
import Factory.FactoryController;
import Factory.Providers.*;
import Factory.Storages.Storage;
import Threadpool.Threadpool;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Creating storages
        Storage<Car> carStorage = new Storage<>(10);
        Storage<Detail> motorStorage = new Storage<>(10);
        Storage<Detail> bodyStorage = new Storage<>(10);
        Storage<Detail> accessoryStorage = new Storage<>(10);

        // Creating providers
        Provider motorProvider = new MotorProvider(1000, motorStorage);
        Provider bodyProvider = new BodyProvider(1000, bodyStorage);
        Provider accessoryProvider = new AccessoryProvider(1000, accessoryStorage);

        // Providers begin providing
        motorProvider.start();
        bodyProvider.start();
        accessoryProvider.start();

        Threadpool pool = new Threadpool(20);
        pool.addTasks(500, accessoryStorage, bodyStorage, motorStorage, carStorage);
        pool.run();

        FactoryController factoryController = new FactoryController(carStorage, pool, accessoryStorage, bodyStorage, motorStorage);

        Dealer dealer = new Dealer(100, carStorage, factoryController);
        dealer.start();

        while(true) {
            sleep(1000);
            System.out.println ("stored: " + carStorage.getAllStored());
            System.out.println("sold: " + carStorage.gerAllBought());
        }
    }
}
