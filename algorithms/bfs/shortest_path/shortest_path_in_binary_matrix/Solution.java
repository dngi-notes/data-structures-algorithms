package algorithms.bfs.shortest_path.shortest_path_in_binary_matrix;

import java.util.*;

public class Solution {
    /**
     * You are given an n x n binary matrix grid.
     * grid[i][j] == 0 represents an open cell
     * grid[i][j] == 1 represents a blocked cell
     * 
     * You may move to any of the 8 adjacent cells (horizontally, vertically, or
     * diagonally).
     * 
     * Return the length of the shortest clear path from the top-left cell (0,0) to
     * the bottom-right cell (n-1,n-1).
     * 
     * If there is no clear path, return -1.
     * e.g.
     * in: grid = [
     * [0,0,0],
     * [1,1,0],
     * [1,1,0]
     * ]
     * out: 4
     */
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    public static int shortestPath(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                if (row == rows - 1 && col == cols - 1) {
                    return steps;
                }

                for (int[] DIR : DIRECTIONS) {
                    int newRow = row + DIR[0];
                    int newCol = col + DIR[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                        q.offer(new int[]{ newRow, newCol });
                        visited[newRow][newCol] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestPath(new int[][]{ {0, 0, 0}, {1, 1, 0}, {1, 1, 0} }));
        System.out.println(shortestPath(new int[][]{{ 1 }}));
    }
}
