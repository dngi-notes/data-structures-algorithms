package neetcode.graphs.islands_and_treasure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IslandsAndTreasure {
    /*
     * You are given a m×n 2D grid initialized with these three possible values:
     * 
     * -1 - A water cell that can not be traversed.
     * 0 - A treasure chest.
     * INF - A land cell that can be traversed. We use the integer 2^31 - 1 =
     * 2147483647 to represent INF.
     * Fill each land cell with the distance to its nearest treasure chest. If a
     * land cell cannot reach a treasure chest then the value should remain INF.
     * 
     * Assume the grid can only be traversed up, down, left, or right.
     */

    private static final int TREASURE_CHEST = 0;
    private static final int LAND = Integer.MAX_VALUE;

    public void islandsAndTreasure(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == TREASURE_CHEST) {
                    q.offer(new int[]{r, c});
                }
            }
        }
        bfs(grid, q, rows, cols);
    }

    private void bfs(int[][] grid, Queue<int[]> q, int rows, int cols) {
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] direction: directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && grid[newRow][newCol] == LAND) {
                    grid[newRow][newCol] = grid[row][col] + 1;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    /*
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */

    public static void main(String[] args) {
        IslandsAndTreasure iat = new IslandsAndTreasure();

        int[][] grid1 = {
            {2147483647, -1, 0, 2147483647},
            {2147483647, 2147483647, 2147483647, -1},
            {2147483647, -1, 2147483647, -1},
            {0, -1, 2147483647, 2147483647}
        };

        iat.islandsAndTreasure(grid1);

        for(int[] row: grid1) {
            System.out.println(Arrays.toString(row));
        }
    }
}
