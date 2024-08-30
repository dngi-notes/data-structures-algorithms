package two_pointers.lc1679_max_number_of_k_sum_pairs;

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
        /*
         * use a hashmap and map each number to its frequency
         * then loop over with two pointers
         * the left pointer will search for the hashmap's key and the right pointer will check for the value
         * if it is found, remove that pair
         */

         Map<Integer, Integer> numFreq = new HashMap<>();
         int operations = 0;

         for(int num: nums) {
            int complement = k - num;
            if(numFreq.getOrDefault(complement, 0) > 0) {
                operations++;
                numFreq.put(complement, numFreq.get(complement) - 1);

            } else {
                numFreq.put(complement, numFreq.getOrDefault(complement, 0) + 1);
            }
         }
        return operations;
    }
}
