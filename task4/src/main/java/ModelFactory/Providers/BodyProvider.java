package ModelFactory.Providers;

import ModelFactory.Details.Body;
import ModelFactory.Details.Detail;
import ModelFactory.Storages.Storage;

public class BodyProvider extends Provider {
    public BodyProvider(int speed, Storage<Detail> storage, OnCompleteProvisionHandler handler) {
        super(speed, storage, handler);
    }

    @Override
    public void provide() throws InterruptedException {
        sleep(speed);
        storage.store(new Body());
    }
}
