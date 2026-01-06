package amazon.medium.lc200_number_of_islands;


public class NumberOfIslands {
    /*
     * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
     * '0's (water), return the number of islands.
     * 
     * An island is surrounded by water and is formed by connecting adjacent lands
     * horizontally or vertically. You may assume all four edges of the grid are all
     * surrounded by water.
     */

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int islandCount = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    searchForIslands(grid, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void searchForIslands(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        searchForIslands(grid, i + 1, j);
        searchForIslands(grid, i - 1, j);
        searchForIslands(grid, i, j + 1);
        searchForIslands(grid, i, j - 1);
    }

    public static void main(String[] args) {
        NumberOfIslands noi = new NumberOfIslands();
        String output = "Output: ";

        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'},
        };

        System.out.println(output + (noi.numIslands(grid1))); // expected output: 3

        char[][] grid2 = null;
        System.out.println(output + noi.numIslands(grid2)); // expected output: 0

        char[][] grid3 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '1', '1', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '1', '1', '1'},
        };
        System.out.println(output + noi.numIslands(grid3)); // expected output: 1
    }


}
