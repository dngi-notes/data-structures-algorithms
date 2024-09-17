package heap_priority_queue.lc215_kth_largest_element_in_array;

import java.util.PriorityQueue;

public class FindKthLargest {
    /*
     * Given an integer array nums and an integer k, return the kth largest element
     * in the array.
     * 
     * Note that it is the kth largest element in the sorted order, not the kth
     * distinct element.
     * 
     * Can you solve it without sorting?
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for(int num : nums) {
            minHeap.offer(num);
        }

        while(minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
