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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
    public static void main(String[] args) {
        FindKthLargest fkl = new FindKthLargest();
        String output = "Output: ";

        int[] nums1 = {1, 2, 3, 5, 4};
        System.out.println(output + fkl.findKthLargest(nums1, 1));
    }
}
