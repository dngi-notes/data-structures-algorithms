package random_leetcode.lc_78_subsets;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Given an integer array nums of unique elements, return all possible
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 */

public class Solution {
    public List<List<Integer>> subset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
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
        System.out.println(s.subset(new int[]{1, 2, 3}));
        System.out.println(s.subset(new int[]{}));
    }
}