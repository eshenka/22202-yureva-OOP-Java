package ModelFactory;

import ModelFactory.Threadpool.Threadpool;


public class Worker extends Thread {
    Threadpool tasks;

    public Worker(Threadpool tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            Task task = tasks.getTask();
            task.run();
        }
    }
}
