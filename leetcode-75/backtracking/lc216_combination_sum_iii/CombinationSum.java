package backtracking.lc216_combination_sum_iii;

import java.util.*;

public class CombinationSum {
    /*
     * Find all valid combinations of k numbers that sum up to n such that the
     * following conditions are true:
     * 
     * Only numbers 1 through 9 are used.
     * Each number is used at most once.
     * Return a list of all possible valid combinations. The list must not contain
     * the same combination twice, and the combinations may be returned in any
     * order.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        getCombinations(combinations, new ArrayList<>(), k, n, 1);
        return combinations;
    }

    private void getCombinations(List<List<Integer>> combinations, List<Integer> combination, int k, int n, int start) {
        if(combination.size() == k && n == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for(int i = start; i <= 9; i++) {
            combination.add(i);
            getCombinations(combinations, combination, k, n - i, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
