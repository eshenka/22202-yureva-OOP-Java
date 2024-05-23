package Factory.Providers;

import Factory.Details.Body;
import Factory.Details.Detail;
import Factory.Storages.Storage;

public class BodyProvider extends Provider {
    public BodyProvider(int speed, Storage<Detail> storage) {
        super(speed, storage);
    }

    @Override
    public void provide() throws InterruptedException {
        sleep(speed);
        storage.store(new Body());
    }
}
