package neetcode.advanced_graphs.lc778_swim_in_rising_water;

import java.util.*;

public class SwimInRisingWater {
    /*
     * You are given an n x n integer matrix grid where each value grid[i][j]
     * represents the elevation at that point (i, j).
     * 
     * The rain starts to fall. At time t, the depth of the water everywhere is t.
     * You can swim from a square to another 4-directionally adjacent square if and
     * only if the elevation of both squares individually are at most t. You can
     * swim infinite distances in zero time. Of course, you must stay within the
     * boundaries of the grid during your swim.
     * 
     * Return the least time until you can reach the bottom right square (n - 1, n -
     * 1) if you start at the top left square (0, 0).
     */

    private static final int[] X_DIR = { -1, 1, 0, 0 };
    private static final int[] Y_DIR = { 0, 0, -1, 1 };

    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int n = grid.length;

        // store {maxElevation so far, row, col}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];

        // starting from the top left square {0, 0}
        minHeap.offer(new int[] { grid[0][0], 0, 0 }); // storing the inital max elevation so far, row and col
        visited[0][0] = true;

        // modified dijkstra's
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int time = current[0], row = current[1], col = current[2];

            // if we reach the bottom right square, return the current max time
            if (row == n - 1 && col == n - 1) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + X_DIR[i];
                int newCol = col + Y_DIR[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    minHeap.offer(new int[] { Math.max(time, grid[newRow][newCol]), newRow, newCol });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SwimInRisingWater sirw = new SwimInRisingWater();
        String output = "Output: ";

        int[][] grid1 = { { 0, 2 }, { 1, 3 } };
        System.out.println(output + sirw.swimInWater(grid1));

        int[][] grid2 = { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 }, { 11, 17, 18, 19, 20 },
                { 10, 9, 8, 7, 6 } };
        System.out.println(output + sirw.swimInWater(grid2));
    }
}
