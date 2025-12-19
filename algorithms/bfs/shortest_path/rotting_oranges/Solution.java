package algorithms.bfs.shortest_path.rotting_oranges;

import java.util.*;

public class Solution {
    /**
     * You are given an m x n grid where:
     * 0 = empty cell
     * 1 = fresh orange
     * 2 = rotten orange
     * 
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
     * orange becomes rotten.
     * 
     * Return the minimum number of minutes that must elapse until no cell has a
     * fresh orange.
     * 
     * If this is impossible, return -1.
     */
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static int rottingOranges(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int timePassed = 0;
        int freshOranges = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == FRESH) {
                    freshOranges++;
                } else if (grid[r][c] == ROTTEN) {
                    q.offer(new int[] { r, c });
                    visited[r][c] = true;
                }
            }
        }

        if (freshOranges == 0) {
            return timePassed;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : DIRECTIONS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                        && !visited[newRow][newCol] && grid[newRow][newCol] == FRESH) {
                            grid[newRow][newCol] = ROTTEN;
                            freshOranges--;
                            q.offer(new int[]{newRow, newCol});
                            visited[newRow][newCol] = true;
                            rotted = true;
                    }
                }
            }

            if (rotted) {
                timePassed++;
            }
        }

        return freshOranges == 0 ? timePassed : -1;
    }

    public static void main(String[] args) {
        System.out.println(rottingOranges(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}})); // expected: 4
    }
}
