package neetcode.graphs.number_of_islands;

public class NumberOfIslands {
    /*
     * Given a 2D grid 'grid' where '1' represents land and '0' represents water,
     * count and return the number of islands.
     * An island is formed by connecting adjacent lands horizontally or vertically
     * and is surrounded by water.
     * You may assume water is surrounding the grid (i.e., all the edges are water).
     */

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    searchForIslands(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * TC: O(m * n)
     * SC: O(m * n)
     */

    private void searchForIslands(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
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

        /* Example 1 - Expected Output: 1 */
        char[][] grid1 = {
                { '0', '1', '1', '1', '0' },
                { '0', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println(noi.numIslands(grid1));

    }
}
