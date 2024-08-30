package two_pointers.lc1679_max_number_of_k_sum_pairs.two_pointer_solution;

import java.util.Arrays;

public class MaxKSumPairs {
    /*
     * You are given an integer array nums and an integer k
     * In one operation you can pick two numbers from the array whose sum equals k and remove them from the array
     * 
     * Return the maximum number of operations you can perform on the array.
     */

    public int maxOperations(int[] nums, int k) {
        int operations = 0;

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum > k) {
                right--;
            }
            else if(sum < k) {
                left++;
            } else {
                operations++;
                left++;
                right--;
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        MaxKSumPairs maxK = new MaxKSumPairs();

        /* Example 1 - Expected Output: 2 */
        int[] nums1 = {1, 2, 3, 4};
        int k1 = 5;
        System.out.println(maxK.maxOperations(nums1, k1));

        /* Example 2 - Expected Output: 1 */
        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;
        System.out.println(maxK.maxOperations(nums2, k2));

        
    }
}
