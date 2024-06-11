package ModelFactory.Dealers;

import ModelFactory.FactoryController;
import ModelFactory.Providers.OnCompleteProvisionHandler;
import View.Event.FactoryEvent;

public class OnCompleteDealHandler {
    FactoryController controller;

    public OnCompleteDealHandler(FactoryController controller) {
        this.controller = controller;
    }

    public void onComplete() {
        controller.upd();
        controller.notify(new FactoryEvent(0));
    }
}
