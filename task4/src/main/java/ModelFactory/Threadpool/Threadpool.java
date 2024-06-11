package ModelFactory.Threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Threadpool {
    LinkedBlockingQueue<Task> tasks;
    List<Worker> workers = new ArrayList<>();
    int workersNumber;

    public Threadpool(int workersNumber) {
        this.tasks = new LinkedBlockingQueue<>();

        this.workersNumber = workersNumber;

        for (int i = 0; i < workersNumber; i++) {
            workers.add(new Worker(this.tasks));
        }
    }

    public void run() {
        for (Worker worker : workers) {
            worker.start();
        }
    }


    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public Task getTask() {
        return tasks.poll();
    }

}
