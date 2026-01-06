package random_leetcode.lc_46_permutations;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }

            permutation.add(nums[i]);
            backtrack(nums, permutation, result);
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permute(new int[]{1, 2, 3}));
    }
}
