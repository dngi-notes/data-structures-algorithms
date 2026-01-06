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

        /*
         * Time Complexity - O(C(9, k)) or O(9 choose k), where we have nine elements and we can only choose k
         * Space Complexity - O(k * C(9, k)), since k is the max recursion depth, and we store each combination in the list `combination`
         */
        
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        String output = "Output: ";

        System.out.println(output + cs.combinationSum3(2, 7)); // expected: [[1, 6], [2, 5], [3, 4]]

        System.out.println(output + cs.combinationSum3(8, 1)); // expected: [[]], since it's impossible to make 1 with 8 digits

        System.out.println(output + cs.combinationSum3(4, 10)); // expected: [[1, 2, 3, 4]]
    }
}
