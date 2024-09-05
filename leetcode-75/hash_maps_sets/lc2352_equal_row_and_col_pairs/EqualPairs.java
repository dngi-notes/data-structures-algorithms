package hash_maps_sets.lc2352_equal_row_and_col_pairs;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class EqualPairs {
    /*
     * Given a 0-indexed n x n integer matrix grid, return the number of pairs (r_i,
     * c_i)
     * such that row r_i and column c_i are equal
     * 
     * A row and column pair is considered equal if they contain the same elements
     * in the same order
     * (i.e. an equal arary).
     */
    public int equalPairs(int[][] grid) {
        /*
         * create a hashmap for each row,
         * with the 0 based index of each row and column as the key,
         * and an array for the column or row as the value
         *
         * create a counter for equalPairs
         * loop over the rowMap and colMap values
         * if they are equal, increment the counter
         * return the final value of the counter
         */
        Map<Integer, int[]> rowMap = new HashMap<>();
        Map<Integer, int[]> colMap = new HashMap<>();

        if(grid == null) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            rowMap.put(i, grid[i]);
        }

        for (int j = 0; j < cols; j++) {
            int[] col = new int[grid.length];
            for (int i = 0; i < rows; i++) {
                col[i] = grid[i][j];
            }
            colMap.put(j, col);
        }

        int equalPairsCount = 0;

        for (int[] row : rowMap.values()) {
            for (int[] col : colMap.values()) {
                if (Arrays.equals(row, col)) {
                    equalPairsCount++;
                }
            }
        }
        return equalPairsCount;
    }

    public static void main(String[] args) {
        EqualPairs ep = new EqualPairs();
        String output = "Output: ";

        /* Example 1 */
        int[][] grid1 = {
                { 3, 2, 1 },
                { 1, 7, 6 },
                { 2, 7, 7 }
        };
        System.out.println(output + ep.equalPairs(grid1)); // expected: 1

        int[][] grid2 = {
                { 3, 1, 2, 2 },
                { 1, 4, 4, 5 },
                { 2, 4, 2, 2 },
                { 2, 4, 2, 2 }
        };
        System.out.println(output + ep.equalPairs(grid2)); // expected: 3

        /* Edge Case 1: Empty Grid */
        int[][] grid3 = {};
        System.out.println(output + ep.equalPairs(grid3)); // expected: 0

        /* Edge Case 2: Single Element Grid */
        int[][] grid4 = {
                { 1 }
        };
        System.out.println(output + ep.equalPairs(grid4)); // expected: 1

        /* Edge Case 3: All Elements Same */
        int[][] grid5 = {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }
        };
        System.out.println(output + ep.equalPairs(grid5)); // expected: 9

        /* Edge Case 4: No Equal Pairs */
        int[][] grid6 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(output + ep.equalPairs(grid6)); // expected: 0

        /* Edge Case 5: Large Grid */
        int[][] grid7 = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
        };
        System.out.println(output + ep.equalPairs(grid7)); // expected: 0
    }
}
