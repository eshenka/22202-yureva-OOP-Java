import Controller.Controller;
import ModelFactory.Factory;

import View.View;

public class Main {
    public static void main(String[] args) {

        Factory factory = new Factory();

        Controller controller = new Controller(factory);

        View view = new View(controller);

        factory.subscribe(view);
        factory.start();

    }
}
