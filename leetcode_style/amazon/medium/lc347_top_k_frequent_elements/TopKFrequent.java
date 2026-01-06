package amazon.medium.lc347_top_k_frequent_elements;

import java.util.*;

public class TopKFrequent {
    /*
     * Given an integer array nums and an integer k, return the k most frequent
     * elements. You may return the answer in any order.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     * 
     * Input: nums = [1], k = 1
     * Output: [1]
     */
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        Map<Integer, Integer> numFreq = new HashMap<>();
        for(int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        k = (k > numFreq.size()) ? numFreq.size() : k;

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(numFreq.entrySet());

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequent tkf = new TopKFrequent();
        String output = "Output: ";

        int[] nums1 = {1, 3, 4, 5, 6, 7, 1, 3, 10};
        System.out.println(output + Arrays.toString(tkf.topKFrequent(nums1, 2))); //expected [1, 3]

        int[] nums2 = {1};
        System.out.println(output + Arrays.toString(tkf.topKFrequent(nums2, 2)));
    }
}
