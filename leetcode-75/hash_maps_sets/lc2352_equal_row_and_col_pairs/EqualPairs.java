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

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            rowMap.put(i, grid[i]);
        }

        for(int j = 0; j < cols; j++) {
            int[] col = new int[grid.length];
            for(int i = 0; i < rows; i++) {
                col[i] = grid[i][j];
            }
            colMap.put(j, col);
        }

        int equalPairsCount = 0;

        for(int[] row: rowMap.values()) {
            for(int[] col: colMap.values()) {
                if(Arrays.equals(row, col)) {
                    equalPairsCount++;
                }
            }
        }
        return equalPairsCount;
    }
}