package blind75.graphs.lc417_pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, atlantic, r, 0, result);
            dfs(heights, atlantic, pacific, r, cols - 1, result);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, atlantic, 0, c, result);
            dfs(heights, atlantic, pacific, rows-1, c, result);
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, boolean[][] other, int row, int col,
            List<List<Integer>> result) {
        if (visited[row][col])
            return;

        visited[row][col] = true;
        if (other[row][col]) {
            result.add(List.of(row, col));
        }

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValid(heights, row, col, newRow, newCol)) {
                dfs(heights, visited, other, newRow, newCol, result);
            }
        }
    }

    private boolean isValid(int[][] heights, int row, int col, int newRow, int newCol) {
        int rows = heights.length;
        int cols = heights[0].length;
        return !(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols
                || heights[newRow][newCol] < heights[row][col]);
    }
}
