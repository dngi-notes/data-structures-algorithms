package two_pointers.lc1679_max_number_of_k_sum_pairs.two_pointer_solution;

import java.util.Arrays;

public class MaxKSumPairs {
    /*
     * You are given an integer array nums and an integer k
     * In one operation you can pick two numbers from the array whose sum equals k
     * and remove them from the array
     * 
     * Return the maximum number of operations you can perform on the array.
     */

    public int maxOperations(int[] nums, int k) {
        int operations = 0;

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > k) {
                right--;
            } else if (sum < k) {
                left++;
            } else {
                operations++;
                left++;
                right--;
            }
        }
        return operations;
    }

    /*
     * time complexity: O(n log n)
     * space complexity O(1)
     */

    public static void main(String[] args) {
        MaxKSumPairs maxK = new MaxKSumPairs();

        /* Example 1 - Expected Output: 2 */
        int[] nums1 = { 1, 2, 3, 4 };
        int k1 = 5;
        System.out.println(maxK.maxOperations(nums1, k1));

        /* Example 2 - Expected Output: 1 */
        int[] nums2 = { 3, 1, 3, 4, 3 };
        int k2 = 6;
        System.out.println(maxK.maxOperations(nums2, k2));

        /* Edge Case 1 - Empty array, Expected Output: 0 */
        int[] nums3 = {};
        int k3 = 5;
        System.out.println(maxK.maxOperations(nums3, k3));

        /* Edge Case 2 - Single element array, Expected Output: 0 */
        int[] nums4 = { 5 };
        int k4 = 5;
        System.out.println(maxK.maxOperations(nums4, k4));

        /* Edge Case 3 - No pairs sum up to k, Expected Output: 0 */
        int[] nums5 = { 1, 2, 3, 4 };
        int k5 = 10;
        System.out.println(maxK.maxOperations(nums5, k5));

        /* Edge Case 4 - All elements are the same and form pairs, Expected Output: 2 */
        int[] nums6 = { 2, 2, 2, 2 };
        int k6 = 4;
        System.out.println(maxK.maxOperations(nums6, k6));

        /* Edge Case 5 - Array Containing Zeroes - Expected Output: 1 */
        int[] nums7 = {0, 0, 0, 5, 0, 0, 0};
        int k7 = 5;
        System.out.println(maxK.maxOperations(nums7, k7));

    }
}
