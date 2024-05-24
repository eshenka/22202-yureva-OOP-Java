package ModelFactory.Providers;

import ModelFactory.Details.Detail;
import ModelFactory.Details.Motor;
import ModelFactory.Storages.Storage;
import ModelFactory.Task;

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
