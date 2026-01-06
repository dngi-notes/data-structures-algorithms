package google.medium.lc_39_combination_sum;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * The test cases are generated such that the number of unique combinations that
 * sum up to target is less than 150 combinations for the given input.
 * 
 * e.g. INPUT: candidates = [2, 3, 6, 7], target = 7
 * OUTPUT: [[2, 2, 3], [7]]
 */

public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        findCombinations(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void findCombinations(List<List<Integer>> result, List<Integer> combination, int[] candidates, int target,
            int index) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }

        combination.add(candidates[index]);

        findCombinations(result, combination, candidates, target - candidates[index], index);
        combination.remove(combination.size() - 1);
        findCombinations(result, combination, candidates, target, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7)); // expected [[2, 2, 3], [7]]
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8)); // expected [2, 2, 2, 2], [2, 3, 3], [3, 5]
        System.out.println(combinationSum(new int[]{2}, 1)); // expected []
    }
}
