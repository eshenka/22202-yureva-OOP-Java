package ModelFactory.Providers;

import ModelFactory.Details.Detail;
import ModelFactory.Details.Motor;
import ModelFactory.Storages.Storage;

public class MotorProvider extends Provider {
    public MotorProvider(int speed, Storage<Detail> storage, OnCompleteProvisionHandler handler) {
        super(speed, storage, handler);
    }

    @Override
    public void provide() throws InterruptedException {
        sleep(speed);
        storage.store(new Motor());
    }
}
