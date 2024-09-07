package queues.lc933_number_of_recent_calls;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    /*
     * You have a RecentCounter class which counts the number of recent requests
     * within a certain time frame.
     * 
     * Implement the RecentCounter class:
     * 
     * RecentCounter() Initializes the counter with zero recent requests.
     * int ping(int t) Adds a new request at time t, where t represents some time in
     * milliseconds, and returns the number of requests that has happened in the
     * past 3000 milliseconds (including the new request). Specifically, return the
     * number of requests that have happened in the inclusive range [t - 3000, t].
     * It is guaranteed that every call to ping uses a strictly larger value of t
     * than the previous call.
     */
    private Queue<Integer> requests;
    public RecentCounter() {
        this.requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.offer(t);

        if(requests.peek() < t - 3000) {
            requests.poll();
        }

        return requests.size();
    }

    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();

        for(int i = 1; i < 10000; i *= 5) {
            System.out.println("Current ping: " + i + " " + "Requests in the last 3000ms: " + rc.ping(i));
        }
    }
}
