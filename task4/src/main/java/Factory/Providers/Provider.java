package Factory.Providers;

import Factory.Details.Detail;
import Factory.Storages.Storage;

abstract public class Provider extends Thread {
    int speed;
    Storage<Detail> storage;

    public Provider(int speed, Storage<Detail> storage) {
        this.speed = speed;
        this.storage = storage;
    }

    abstract public void provide() throws InterruptedException;

    @Override
    public void run() {
        while (true) {
            try {
                provide();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
