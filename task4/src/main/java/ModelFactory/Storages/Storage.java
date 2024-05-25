package ModelFactory.Storages;

import Controller.Controller;
import ModelFactory.FactoryController;
import View.Event.FactoryEvent;

import java.util.LinkedList;

public class Storage<T> {
    FactoryController controller;
    LinkedList<T> stored;
    int capacity;
    private int storedAll = 0;
    private int bought = 0;

    public Storage(int capacity, FactoryController controller) {
        this.capacity = capacity;
        this.stored = new LinkedList<>();
        this.controller = controller;
    }

    public boolean isFull() {
        return stored.size() == capacity;
    }

    synchronized public int getCurrentSize() {
        return stored.size();
    }
    synchronized public void store(T detail) throws InterruptedException {
        while (isFull()) {
            wait();
        }

        controller.notify(new FactoryEvent(storedAll));

        notify();

        storedAll++;
        stored.add(detail);
    }

    synchronized public T get() throws InterruptedException {
        while (stored.isEmpty()) {
            wait();
        }

        controller.notify(new FactoryEvent(bought));

        notify();

        bought++;
        return stored.poll();
    }

    synchronized public int getAllStored() {
        return storedAll;
    }

    synchronized public int getAllBought() {
        return bought;
    }

    synchronized public int gerCurrentSize() {
        return stored.size();
    }
}
