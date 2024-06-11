package ModelFactory.Threadpool;

import java.util.concurrent.BlockingQueue;

public class Worker extends Thread {
    BlockingQueue<Task> tasks;
    public Worker(BlockingQueue<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            while (tasks.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            Task workerTask = tasks.poll();
            workerTask.run();
        }
    }
}
