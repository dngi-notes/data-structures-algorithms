package amazon.medium.lc215_kth_largest_in_an_array;

import java.util.*;

public class KthLargest {
    /*
     * Given an integer array nums and an integer k, return the kth largest element
     * in the array.
     * 
     * Note that it is the kth largest element in the sorted order, not the kth
     * distinct element.
     * 
     * Can you solve it without sorting?
     */

    /*
     * use a priority queue (maxHeap to get all the largest elements in the queue)
     * loop k times and poll from the queue until we've polled k times
     * return the value at k
     */

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return  minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargest kl = new KthLargest();
        String output = "Output: ";

        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println(output + kl.findKthLargest(nums1, 2)); // expected 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(output + kl.findKthLargest(nums2, 4)); // expected 4
    }
}
