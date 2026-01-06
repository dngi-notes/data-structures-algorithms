package random_leetcode.walls_and_gates;

import java.util.*;

public class Solution {
    /**
     * You are given a m×n 2D grid initialized with these three possible values:
     * 
     * -1 - A water cell that can not be traversed.
     * 0 - A treasure chest.
     * INF - A land cell that can be traversed. We use the integer 2^31 - 1 =
     * 2147483647 to represent INF.
     * 
     * Fill each land cell with the distance to its nearest treasure chest. If a
     * land cell cannot reach a treasure chest then the value should remain INF.
     * 
     * Assume the grid can only be traversed up, down, left, or right.
     * 
     * Modify the grid in-place.
     * 
     * Example 1:
     * 
     * Input: [
     * [2147483647,-1,0,2147483647],
     * [2147483647,2147483647,2147483647,-1],
     * [2147483647,-1,2147483647,-1],
     * [0,-1,2147483647,2147483647]
     * ]
     * 
     * Output: [
     * [3,-1,0,1],
     * [2,2,1,-1],
     * [1,-1,2,-1],
     * [0,-1,3,4]
     * ]
     * 
     * Example 2:
     * 
     * Input: [
     * [0,-1],
     * [2147483647,2147483647]
     * ]
     * 
     * Output: [
     * [0,-1],
     * [1,2]
     * ]
     * 
     * Constraints:
     * 
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 100
     * grid[i][j] is one of {-1, 0, 2147483647}
     * 
     */

    private final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int TREASURE = 0;
    private static final int LAND = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == TREASURE) {
                    q.offer(new int[]{r, c});
                }
            }
        }
        bfs(grid, q);
    }

    private void bfs(int[][] grid, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                    && grid[newRow][newCol] == LAND) {
                        grid[newRow][newCol] = grid[row][col] + 1;
                        q.add(new int[]{newRow, newCol});
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = {
            {2147483647, -1, 0, 2147483647},
            {2147483647, 2147483647, 2147483647, -1},
            {2147483647, -1, 2147483647, -1},
            {0, -1, 2147483647, 2147483647}
        };
        int[][] grid2 = {
            {LAND, LAND, LAND},
            {LAND, TREASURE, LAND},
            {LAND, LAND, LAND}
        };

        sol.islandsAndTreasure(grid1);
        sol.islandsAndTreasure(grid2);

        for(int[] row: grid1) {
            System.out.println(Arrays.toString(row));
        }

        for (int[] row : grid2) {
            System.out.println(Arrays.toString(row));
        }
    }
}
