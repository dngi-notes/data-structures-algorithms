package random_leetcode.lc1863_sum_of_all_subset_xor_totals;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int subsetXORSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, subsets, new ArrayList<>(), 0);

        int xorTotalSum = 0;
        for (List<Integer> subset : subsets) {
            int xorSubset = 0;
            for (int num : subset) {
                xorSubset ^= num;
            }
            xorTotalSum += xorSubset;
        }

        return xorTotalSum;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> subset, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        backtrack(nums, result, subset, index + 1);
        subset.remove(subset.size() - 1);
        backtrack(nums, result, subset, index + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsetXORSum(new int[]{1, 3}));
        System.out.println(s.subsetXORSum(new int[]{3, 1, 1}));
        System.out.println(s.subsetXORSum(new int[]{2, 4}));
    }
}
