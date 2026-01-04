package algorithms.bfs.multi_source.people_to_nearest_exits;

import java.util.*;

public class Solution {
    /**
     * given:
     * a 2D grid int[] grid, filled with the following values:
     * 0 -> exits
     * 1 -> people
     * -1 -> walls (blocked)
     * 
     * goal: fill each 1 with the distance to the nearest 0
     * e.g.
     * [
     * [0, 1, 1],
     * [1, -1, 1],
     * [1, 1, 1]
     * ]
     * 
     * 
     */
    private static final int[][] DIRS = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private static final int EXIT = 0;
    private static final int WALL = -1;
    private static final int PEOPLE = 1;

    public static void findClosest(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == EXIT) {
                    q.offer(new int[] { r, c });
                    dist[r][c] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : DIRS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] != WALL && dist[newRow][newCol] == -1) {
                    q.offer(new int[] { newRow, newCol });
                    dist[newRow][newCol] = dist[row][col] + 1;
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == PEOPLE) {
                    grid[r][c] = dist[r][c];
                }
            }
        }
    }
}