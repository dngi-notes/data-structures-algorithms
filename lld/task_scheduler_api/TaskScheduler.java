package lld.task_scheduler_api;

import java.util.*;

/**
 * designing a task scheduler that runs one task at a time
 * 
 * void submitTask(long time); // time at which the task is ready to run
 * long getNextTask() // returns time of the next task to execute or -1 if none
 * 
 * RULES:
 * - tasks can be submitted in any order
 * - scheduler keeps a currentTime
 * - tasks can only be run if task.time >= currentTime
 * - when getNextTask() is called:
 *  - return the smallest runnable task time >= currentTime
 *  - updateCurrentTime to that value
 * - if no runnable time, return -1;
 */
public class TaskScheduler {
    private PriorityQueue<Long> scheduler;
    private long currentTime;
    
    public TaskScheduler() {
        this.scheduler = new PriorityQueue<>();
        this.currentTime = 0;
    }

    public void submitTask(long time) {
        scheduler.offer(time);
    }

    public long getNextTask() {
        while (!scheduler.isEmpty() && currentTime > scheduler.peek()) {
            scheduler.poll();
        }

        long nextTask = -1;
        if (scheduler.isEmpty()) {
            return -1;
        } else {
            long nt = scheduler.poll();
            nextTask = nt;
            currentTime = nextTask;
        }

        return nextTask;
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        ts.currentTime = 5;
        ts.submitTask(10);
        ts.submitTask(8);
        System.out.println(ts.getNextTask());
        System.out.println(ts.getNextTask());
    }
}