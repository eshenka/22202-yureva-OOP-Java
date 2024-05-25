package ModelFactory.Providers;

import ModelFactory.Details.Detail;
import ModelFactory.Storages.Storage;

abstract public class Provider extends Thread {
    int speed;
    Storage<Detail> storage;
    OnCompleteProvisionHandler handler;

    public Provider(int speed, Storage<Detail> storage, OnCompleteProvisionHandler handler) {
        this.speed = speed;
        this.storage = storage;
        this.handler = handler;
    }

    abstract public void provide() throws InterruptedException;

    @Override
    public void run() {
        while (true) {
            try {
                provide();
                handler.onComplete();
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
