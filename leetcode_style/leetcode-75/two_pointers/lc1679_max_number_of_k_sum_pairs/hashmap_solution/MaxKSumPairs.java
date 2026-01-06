package two_pointers.lc1679_max_number_of_k_sum_pairs.hashmap_solution;

import java.util.HashMap;
import java.util.Map;

public class MaxKSumPairs {
    /*
     * You are given an integer array nums and an integer k
     * In one operation you can pick two numbers from the array whose sum equals k and remove them from the array
     * 
     * Return the maximum number of operations you can perform on the array.
     */

    public int maxOperations(int[] nums, int k) {
         Map<Integer, Integer> numFreq = new HashMap<>();
         int operations = 0;

         for(int num: nums) {
            int complement = k - num;
            if(numFreq.getOrDefault(complement, 0) > 0) {
                operations++;
                numFreq.put(complement, numFreq.get(complement) - 1);

            } else {
                numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
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
