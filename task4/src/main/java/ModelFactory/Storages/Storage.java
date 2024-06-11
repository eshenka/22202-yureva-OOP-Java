package ModelFactory.Storages;

import java.util.LinkedList;

public class Storage<T> {
    LinkedList<T> stored;
    int capacity;
    private int storedAll = 0;
    private int bought = 0;

    public Storage(int capacity) {
        this.capacity = capacity;
        this.stored = new LinkedList<>();
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

        notifyAll();

        storedAll++;
        stored.add(detail);
    }

    synchronized public T get() throws InterruptedException {
        while (stored.isEmpty()) {
            wait();
        }

        notifyAll();

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
