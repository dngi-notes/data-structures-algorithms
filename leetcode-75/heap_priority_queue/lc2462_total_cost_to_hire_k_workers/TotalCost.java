package heap_priority_queue.lc2462_total_cost_to_hire_k_workers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TotalCost {
    /*
     * You are given a 0-indexed integer array costs where costs[i] is the cost of
     * hiring the ith worker.
     * 
     * You are also given two integers k and candidates. We want to hire exactly k
     * workers according to the following rules:
     * 
     * You will run k sessions and hire exactly one worker in each session.
     * In each hiring session, choose the worker with the lowest cost from either
     * the first candidates workers or the last candidates workers. Break the tie by
     * the smallest index.
     * 
     * For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first
     * hiring session, we will choose the 4th worker because they have the lowest
     * cost [3,2,7,7,1,2].
     * 
     * In the second hiring session, we will choose 1st worker because they have the
     * same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2].
     * 
     * Please note that the indexing may be changed in the process.
     * If there are fewer than candidates workers remaining, choose the worker with
     * the lowest cost among them. Break the tie by the smallest index.
     * A worker can only be chosen once.
     * Return the total cost to hire exactly k workers.
     * 
     * 
     */
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headQueue = new PriorityQueue<>();
        PriorityQueue<Integer> tailQueue = new PriorityQueue<>();
        int len = costs.length;

        for(int i = 0; i < candidates && i < len; i++) {
            headQueue.offer(costs[i]);
        }

        for(int i = Math.max(candidates, len - candidates); i < len; i++) {
            tailQueue.offer(costs[i]);
        }

        long totalCost = 0;

        int left = 0;
        int right = len - candidates - 1;

        for(int i = 0; i < k; i++) {
            if(tailQueue.isEmpty() || !headQueue.isEmpty() && headQueue.peek() <= tailQueue.peek()) {
                totalCost += headQueue.poll();

                if(left <= right) {
                    headQueue.offer(costs[left]);
                    left++;
                }
            } else {
                totalCost += tailQueue.poll();

                if(right >= left) {
                    headQueue.offer(costs[right]);
                    right--;
                }
            }
        }        
        return totalCost;
    }

    public static void main(String[] args) {
        TotalCost tc = new TotalCost();
        String output = "Output: ";

        int[] costs1 = {3, 2, 7, 7, 1, 2};
        int k1 = 4;
        int candidates1 = 2;
        System.out.println(output + tc.totalCost(costs1, k1, candidates1)); // expected output: 8

        int[] costs2 = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k2 = 3;
        int candidates2 = 4;
        System.out.println(output + tc.totalCost(costs2, k2, candidates2)); // expected output: 2 + 2 + 7
    }
}
