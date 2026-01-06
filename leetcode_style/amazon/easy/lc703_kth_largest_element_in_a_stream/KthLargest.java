package amazon.easy.lc703_kth_largest_element_in_a_stream;

import java.util.PriorityQueue;

/*
 * You are part of a university admissions office and need to keep track of the
 * kth highest test score from applicants in real-time. This helps to determine
 * cut-off marks for interviews and admissions dynamically as new applicants
 * submit their scores.
 * 
 * You are tasked to implement a class which, for a given integer k, maintains a
 * stream of test scores and continuously returns the kth highest test score
 * after a new score has been submitted. More specifically, we are looking for
 * the kth highest score in the sorted list of all scores.
 * 
 * Implement the KthLargest class:
 * 
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and
 * the stream of test scores nums.
 * int add(int val) Adds a new test score val to the stream and returns the
 * element representing the kth largest element in the pool of test scores so
 * far.
 */
public class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 8, 2};
        KthLargest kl1 = new KthLargest(3, nums1);

        String currentKthLargest = "Current Kth Largest: ";

        System.out.println(currentKthLargest + kl1.add(3));
        System.out.println(currentKthLargest + kl1.add(5));
        System.out.println(currentKthLargest + kl1.add(10));
        System.out.println(currentKthLargest + kl1.add(9));

    }
}