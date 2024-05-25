package ModelFactory.Threadpool;

public abstract class Task implements Runnable {
    public Task() {}
    public abstract void run();
}
