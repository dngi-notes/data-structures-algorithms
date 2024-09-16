package graphs.bfs.lc1926_nearest_exit_from_entrance_in_maze;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExit {
    /*
     * You are given an m x n matrix maze (0-indexed) with empty cells (represented
     * as '.') and walls (represented as '+'). You are also given the entrance of
     * the maze, where entrance = [entrancerow, entrancecol] denotes the row and
     * column of the cell you are initially standing at.
     * 
     * In one step, you can move one cell up, down, left, or right. You cannot step
     * into a cell with a wall, and you cannot step outside the maze. Your goal is
     * to find the nearest exit from the entrance. An exit is defined as an empty
     * cell that is at the border of the maze. The entrance does not count as an
     * exit.
     * 
     * Return the number of steps in the shortest path from the entrance to the
     * nearest exit, or -1 if no such path exists.
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        if (maze == null || maze.length == 0 || maze[0].length == 0 || maze[entrance[0]][entrance[1]] == '+') {
            return -1;
        }

        int rows = maze.length;
        int cols = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;

        return bfs(maze, queue, visited, entrance);
    }

    private int bfs(char[][] maze, Queue<int[]> queue, boolean[][] visited, int[] entrance) {
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int steps = 0;

        int rows = maze.length;
        int cols = maze[0].length;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && maze[newRow][newCol] == '.'
                            && !visited[newRow][newCol]) {
                        if (newRow == 0 || newRow == rows - 1 || newCol == 0 || newCol == cols - 1) {
                            return steps;
                        }
                        queue.offer(new int[] { newRow, newCol });
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        NearestExit solver = new NearestExit();

        // Test Case 1: Basic Test Case
        char[][] maze1 = {
                { '+', '+', '.', '+' },
                { '.', '.', '.', '+' },
                { '+', '+', '+', '.' }
        };
        int[] entrance1 = { 1, 2 };
        System.out.println(solver.nearestExit(maze1, entrance1)); // Expected output: 1

        // Test Case 2: No Exit
        char[][] maze2 = {
                { '+', '+', '+', '+' },
                { '+', '.', '.', '+' },
                { '+', '+', '+', '+' }
        };
        int[] entrance2 = { 1, 1 };
        System.out.println(solver.nearestExit(maze2, entrance2)); // Expected output: -1

        // Test Case 3: Multiple Exits
        char[][] maze3 = {
                { '+', '.', '+', '+', '+', '+', '+' },
                { '+', '.', '.', '.', '.', '.', '+' },
                { '+', '+', '+', '+', '.', '+', '.' }
        };
        int[] entrance3 = { 1, 0 };
        System.out.println(solver.nearestExit(maze3, entrance3)); // Expected output: -1

        // Test Case 4: Entrance on Border
        char[][] maze4 = {
                { '+', '.', '+' },
                { '.', '.', '.' },
                { '+', '+', '+' }
        };
        int[] entrance4 = { 0, 1 };
        System.out.println(solver.nearestExit(maze4, entrance4)); // Expected output: 2

        // Test Case 5: Complex Maze
        char[][] maze5 = {
                { '+', '+', '+', '+', '+', '+', '+' },
                { '+', '.', '.', '.', '.', '.', '+' },
                { '+', '.', '+', '+', '+', '.', '+' },
                { '+', '.', '+', '.', '+', '.', '+' },
                { '+', '.', '+', '.', '.', '.', '+' },
                { '+', '+', '+', '+', '+', '+', '+' }
        };
        int[] entrance5 = { 1, 1 };
        System.out.println(solver.nearestExit(maze5, entrance5)); // Expected output: -1
    }
}
