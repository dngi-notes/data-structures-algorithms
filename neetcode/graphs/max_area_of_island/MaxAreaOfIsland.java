package neetcode.graphs.max_area_of_island;

public class MaxAreaOfIsland {
    /*
     * You are given a matrix 'grid' where 'grid[i]' is either a 0 (representing
     * water) or 1 (representing land)
     * An island is defined asa group of 1s connected horizontally or vertically.
     * You may assume all four edges of the grid are surrounded by water.
     * The area of an island is defined as the number of cells within the island
     */

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, calculateArea(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private int calculateArea(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        int area = 1;

        area += calculateArea(grid, r + 1, c);
        area += calculateArea(grid, r - 1, c);
        area += calculateArea(grid, r, c + 1);
        area += calculateArea(grid, r, c - 1);

        return area;
    }

    /*
     * time complexity: O(m * n)
     * space complexity: O(m * n)
     */

    public static void main(String[] args) {
        String output = "Output: ";
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        /* Example 1 - Expected Output: 6 */
        int[][] grid1 = {
                { 0, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 0, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 1 },
        };
        System.out.println(output + maxAreaOfIsland.maxAreaOfIsland(grid1));

        // Test Case 2 - Empty Grid - Expected Output: 0
        int[][] grid2 = {};
        System.out.println(output + maxAreaOfIsland.maxAreaOfIsland(grid2));

        // Test Case 3 - Single Cell Island - Expected Output: 1
        int[][] grid3 = {
                { 1 }
        };
        System.out.println(output + maxAreaOfIsland.maxAreaOfIsland(grid3));

        // Test Case 4 - All Water - Expected Output: 0
        int[][] grid4 = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        System.out.println(output + maxAreaOfIsland.maxAreaOfIsland(grid4));

        // Test Case 5 - All Land - Expected Output: 9
        int[][] grid5 = {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }
        };
        System.out.println(output + maxAreaOfIsland.maxAreaOfIsland(grid5));

        // Test Case 6 - Multiple Disconnected Islands - Expected Output: 3
        int[][] grid6 = {
                { 1, 0, 0, 1 },
                { 0, 1, 0, 0 },
                { 0, 0, 1, 1 },
                { 1, 0, 0, 1 }
        };
        System.out.println(output + maxAreaOfIsland.maxAreaOfIsland(grid6));

    }
}
