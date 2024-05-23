package Threadpool;

import Controller.Task;
import Factory.Details.*;
import Factory.Storages.Storage;
import Factory.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Threadpool {
    LinkedBlockingQueue<Task> tasks;
    List<Worker> workers = new ArrayList<>();
    int workersNumber;

    public Threadpool(int workersNumber) {
        this.tasks = new LinkedBlockingQueue<>();

        this.workersNumber = workersNumber;

        for (int i =0; i < workersNumber; i++) {
            workers.add(new Worker(this));
        }
    }

    public void run() {
        for (Worker worker : workers) {
            worker.start();
        }
    }


    public void addTasks(int tasksNumber, Storage<Detail> detail, Storage<Detail> body, Storage<Detail> motor, Storage<Car> car) {
        for (int i = 0; i < tasksNumber; i++) {
            tasks.add(new Task(detail, body, motor, car));
        }
    }

    public Task getTask() {
        return tasks.poll();
    }

}
