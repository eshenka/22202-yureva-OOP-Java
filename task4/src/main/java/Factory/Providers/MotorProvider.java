package Factory.Providers;

import Factory.Details.Detail;
import Factory.Details.Motor;
import Factory.Storages.Storage;

public class MotorProvider extends Provider {
    public MotorProvider(int speed, Storage<Detail> storage) {
        super(speed, storage);
    }

    @Override
    public void provide() throws InterruptedException {
        sleep(speed);
        storage.store(new Motor());
    }
}
