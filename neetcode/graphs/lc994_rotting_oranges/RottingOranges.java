package neetcode.graphs.lc994_rotting_oranges;

import java.util.Queue;
import java.util.LinkedList;

public class RottingOranges {

    /*
     * You are given an m x n grid where each cell can have one of three values:
     * 
     * 0 representing an empty cell
     * 1 representing a fresh orange
     * 2 representing a rotten orange
     * 
     * every minute, any fresh orange that is 4 directionally adjacent to a rotten
     * orange
     * becomes rotten
     * 
     * return the minimum number of minutes that must elapse until no cell has a
     * fresh orange.
     * If this is impossible return -1
     */

    // declare final variablse for the empty cells, fresh oranges, and rotten
    // oranges
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;

    public int orangesRotting(int[][] grid) {
        /*
         * create a queue to store the coordinates of all rotten oranges
         * initialise a count for all fresh oranges
         * 
         * iterate over rows and cols
         * -> if we encounter a rotten orange, add it to the queue
         * -> if we encounter a fresh orange increase the count of fresh oranges
         * 
         * if we have no fresh oranges, return 0
         * 
         * 
         * execute bfs function to spread the rot and keep track of the minutes
         */

        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == ROTTEN) {
                    q.offer(new int[] { r, c });
                }

                if (grid[r][c] == FRESH) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        return bfs(grid, q, rows, cols, freshOranges);

    }
    /*
     * bfs method to spread the rot and keep track of the minutes to return
     * 
     * define the 4-directions we can move in (up, down, left, right)
     * define a variable for minutes that will increase.
     * 
     * while the queue isnt empty:
     * -> define our cell by removing it from the queue
     * -> extract row and col from the cell
     * 
     * 
     * -> use the row and col, with our directions to get the newRow and newCol
     * 
     * if we are in bounds, and the position at newRow, newCol is a fresh orange
     * -> turn it into a rotten orange
     * 
     * 
     * return the number of minutes
     */

    private int bfs(int[][] grid, Queue<int[]> q, int rows, int cols, int freshOranges) {
        int minutesPassed = -1;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!q.isEmpty()) {
            minutesPassed++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && grid[newRow][newCol] == FRESH) {
                        grid[newRow][newCol] = ROTTEN;
                        freshOranges--;
                        q.offer(new int[] { newRow, newCol });
                    }
                }
            }
        }

        if (freshOranges == 0) {
            return minutesPassed;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();

        // Test case 1: Basic case with some fresh and rotten oranges
        int[][] grid1 = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        System.out.println("Test case 1: " + solution.orangesRotting(grid1)); // Expected output: 4

        // Test case 2: All oranges are already rotten
        int[][] grid2 = {
                { 2, 2, 2 },
                { 2, 2, 2 },
                { 2, 2, 2 }
        };
        System.out.println("Test case 2: " + solution.orangesRotting(grid2)); // Expected output: 0

        // Test case 3: No oranges at all
        int[][] grid3 = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        System.out.println("Test case 3: " + solution.orangesRotting(grid3)); // Expected output: 0

        // Test case 4: Fresh oranges that cannot be reached by rotten ones
        int[][] grid4 = {
                { 2, 1, 1 },
                { 0, 1, 1 },
                { 1, 0, 1 }
        };
        System.out.println("Test case 4: " + solution.orangesRotting(grid4)); // Expected output: -1

        // Test case 5: Single fresh orange
        int[][] grid5 = {
                { 1 }
        };
        System.out.println("Test case 5: " + solution.orangesRotting(grid5)); // Expected output: -1

        // Test case 6: Single rotten orange
        int[][] grid6 = {
                { 2 }
        };
        System.out.println("Test case 6: " + solution.orangesRotting(grid6)); // Expected output: 0

        // Test case 7: Mixed grid with no fresh oranges
        int[][] grid7 = {
                { 2, 0, 2 },
                { 0, 2, 0 },
                { 2, 0, 2 }
        };
        System.out.println("Test case 7: " + solution.orangesRotting(grid7)); // Expected output: 0
    }
}