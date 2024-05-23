package Factory;

import Controller.Task;
import Threadpool.Threadpool;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


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
