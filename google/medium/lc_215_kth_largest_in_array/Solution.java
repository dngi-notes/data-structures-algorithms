package google.medium.lc_215_kth_largest_in_array;

import java.util.*;

public class Solution {
    /**
     * given:
     * int[] nums, int k
     * 
     * return 'ans' -> the kth largest element in the array
     * note that it is the kth largest element in sorted order, not the kth distinct element
     * 
     * nums = [3, 2, 1, 5, 6, 4] -> pq (size k) [6, 5]
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            System.out.println("current heap: " + minHeap);
        }
    
        return minHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // expected: 5        
    }
}