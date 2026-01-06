package heap_priority_queue.lc2336_smallest_number_in_infinite_set;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSet {
    /*
     * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
     * 
     * Implement the SmallestInfiniteSet class:
     * 
     * SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain
     * all positive integers.
     * 
     * int popSmallest() Removes and returns the smallest integer contained in the
     * infinite set.
     * 
     * void addBack(int num) Adds a positive integer num back into the infinite set,
     * if it is not already in the infinite set.
     */
    private PriorityQueue<Integer> minHeap;
    private Set<Integer> set;
    private int nextNumber;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        set = new HashSet<>();
        nextNumber = 1;
    }

    public int popSmallest() {
        if(minHeap.isEmpty()) {
            return nextNumber++;
        } else {
            int smallest = minHeap.poll();
            set.remove(smallest);
            return smallest;
        }
    }

    public void addBack(int num) {
        if(num < nextNumber && set.add(num)) {
            minHeap.offer(num);
        }
    }
}
