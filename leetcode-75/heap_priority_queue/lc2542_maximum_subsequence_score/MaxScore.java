package heap_priority_queue.lc2542_maximum_subsequence_score;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxScore {
    /*
     * You are given two 0-indexed integer arrays nums1 and nums2 of equal length n
     * and a positive integer k. You must choose a subsequence of indices from nums1
     * of length k.
     * 
     * For chosen indices i0, i1, ..., ik - 1, your score is defined as:
     * 
     * The sum of the selected elements from nums1 multiplied with the minimum of
     * the selected elements from nums2.
     * It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) *
     * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
     * Return the maximum possible score.
     * 
     * A subsequence of indices of an array is a set that can be derived from the
     * set {0, 1, ..., n-1} by deleting some or no elements.
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return 0;
        }

        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        long sum = 0;
        long maxScore = 0;

        for (int i = 0; i < n; i++) {
            int num1 = pairs[i][0];
            int num2 = pairs[i][1];

            minHeap.add(num1);
            sum += num1;

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * num2);
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        MaxScore ms = new MaxScore();
        String output = "Output: ";

        int[] nums1 = { 1, 3, 3, 2 };
        int[] nums2 = { 2, 1, 3, 4 };
        /* Example 1 */
        System.out.println(output + ms.maxScore(nums1, nums2, 3)); // expected: 12

        /* Example 2 */
        System.out.println(output + ms.maxScore(nums1, nums2, 0)); // expected: 0

        /* Example 3 */
        int[] nums3 = {};
        int[] nums4 = {};
        System.out.println(output + ms.maxScore(nums3, nums4, 1)); // expected: 0

        /* Example 4 */
        int[] nums5 = { 5 };
        int[] nums6 = { 10 };
        System.out.println(output + ms.maxScore(nums5, nums6, 1)); // expected: 50

        /* Example 5 */
        int[] nums7 = { 1, 2, 3 };
        int[] nums8 = { 4, 5, 6 };
        System.out.println(output + ms.maxScore(nums7, nums8, 4)); // expected: 0

        /* Example 6 */
        int[] nums9 = { 2, 2, 2 };
        int[] nums10 = { 2, 2, 2 };
        System.out.println(output + ms.maxScore(nums9, nums10, 2)); // expected: 8

        /* Example 7 */
        int[] nums11 = { -1, -2, -3 };
        int[] nums12 = { -4, -5, -6 };
        System.out.println(output + ms.maxScore(nums11, nums12, 2)); // expected: 18
    }
}
