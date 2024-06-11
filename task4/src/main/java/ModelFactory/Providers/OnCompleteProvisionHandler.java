package ModelFactory.Providers;

import ModelFactory.FactoryController;
import View.Event.FactoryEvent;

public class OnCompleteProvisionHandler {
    FactoryController controller;

    public OnCompleteProvisionHandler(FactoryController controller) {
        this.controller = controller;
    }

    public void onComplete() {
        controller.notify(new FactoryEvent(0));
    }
}
