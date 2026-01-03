package algorithms.bfs.shortest_path.shortest_path_with_obstacles;

import java.util.*;

public class Solution {
    private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        if (rows == 1 && cols == 1) return 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[rows][cols][k + 1];

        q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];
                int obstaclesUsed = cell[2];

                if (row == rows - 1 && col == cols - 1) {
                    return steps;
                }
                
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newCol < rows && newCol >= 0 && newCol < cols) continue;
                    int nextUsed = obstaclesUsed + grid[newRow][newCol];

                    if (nextUsed <= k && !visited[newRow][newCol][nextUsed]) {
                        visited[newRow][newCol][nextUsed] = true;
                        q.offer(new int[]{newRow, newCol, nextUsed});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
