import Controller.Controller;
import ModelFactory.Details.*;
import ModelFactory.Factory;
import ModelFactory.Providers.*;

import View.View;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        Factory factory = new Factory();

        Controller controller = new Controller(factory);

        View view = new View(controller);

        factory.subscribe(view);
        factory.start();

    }
}
