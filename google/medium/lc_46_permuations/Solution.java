package google.medium.lc_46_permuations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuHelper(nums, result, new ArrayList<>());
        return result;
    }

    private static void permuHelper(int[] nums, List<List<Integer>> result, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }

            permutation.add(nums[i]);
            permuHelper(nums, result, permutation);
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
