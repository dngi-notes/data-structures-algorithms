package neetcode.arrays_hashing.top_k_elements_in_list;

import java.util.*;

public class TopKElements {
    /*
     * Given an integer array nums and an integer k, return the k most frequent
     * elements within the array.
     * 
     * The test cases are generated such that the answer is always unique.
     * 
     * You may return the output in any order.
     */

    public int[] topKFrequent(int[] nums, int k) {
        /*
         * get frequency of elements in nums (hashmap)
         * add frequencies to a list sorted from highest to lowest
         * loop over frequencies until k
         * store those in a final result array 
         */
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> sortedByFreq = new ArrayList<>(freqMap.keySet());
        sortedByFreq.sort((a, b) -> freqMap.get(b) - freqMap.get(a));

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = sortedByFreq.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        TopKElements tke = new TopKElements();
        String output = "Output: ";

        int[] nums1 = {1, 2, 2, 3, 3, 3};
        System.out.println(output + Arrays.toString(tke.topKFrequent(nums1, 2)));
    }
}