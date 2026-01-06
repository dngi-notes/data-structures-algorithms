package blind75.heaps.lc_347_top_k_frequent_elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }        

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freq.entrySet());
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(maxHeap.poll().getKey());
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}


