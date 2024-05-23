package Factory.Providers;

import Factory.Details.Accessory;
import Factory.Details.Detail;
import Factory.Storages.Storage;

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
