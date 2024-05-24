package ModelFactory.Providers;

import ModelFactory.Details.Accessory;
import ModelFactory.Details.Detail;
import ModelFactory.Storages.Storage;

public class AccessoryProvider extends Provider {
    public AccessoryProvider(int speed, Storage<Detail> storage) {
        super(speed, storage);
    }

    @Override
    public void provide() throws InterruptedException {
        sleep(speed);
        storage.store(new Accessory());
    }
}
