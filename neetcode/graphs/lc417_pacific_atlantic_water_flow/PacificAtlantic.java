package neetcode.graphs.lc417_pacific_atlantic_water_flow;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

/*
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. 
The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] 
represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west 
if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent 
to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) 
to both the Pacific and Atlantic oceans.
*/

public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*
         * initialise the result list
         * base check for null, empty, rows, and cols
         * assign 2d boolean arrays to check if pacific and atlantic
         * create queues for both atlantic and pacific
         * iterate over the rows and cols to define borders
         * -> add them to the queues
         * -> mark them as visited
         * 
         * do a bfs on both oceans
         * 
         * iterate over rows and cols
         * if the pacific and atlantic are visited
         * 
         */

        List<List<Integer>> res = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        
        int rows = heights.length;
        int cols = heights[0].length;


        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            pacQ.offer(new int[] { i, 0 });
            atlQ.offer(new int[] { i, cols - 1 });
            pacific[i][0] = true;
            atlantic[rows - 1][0] = true;
        }

        for (int j = 0; j < cols; j++) {
            pacQ.offer(new int[] { 0, j });
            atlQ.offer(new int[] { rows - 1, j });
            pacific[0][j] = true;
            atlantic[rows - 1][j] = true;
        }
        bfs(heights, pacQ, pacific);
        bfs(heights, atlQ, atlantic);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || visited[newRow][newCol]
                        || heights[newRow][newCol] < heights[row][col]) {
                    continue;
                }

                visited[newRow][newCol] = true;
                q.offer(new int[] { newRow, newCol });
            }
        }
    }
    /*
     * time complexity: O(m * n)
     * space complexity: O(m * n)
     */
    public static void main(String[] args) {
        PacificAtlantic pa = new PacificAtlantic();
        
        // Test case 1: Simple case
    int[][] heights1 = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    };
    System.out.println("Test case 1: " + pa.pacificAtlantic(heights1));

    // Test case 2: All cells can flow to both oceans
    int[][] heights2 = {
        {1, 1},
        {1, 1}
    };
    System.out.println("Test case 2: " + pa.pacificAtlantic(heights2));

    // Test case 3: No cells can flow to both oceans
    int[][] heights3 = {
        {10, 10, 10},
        {10, 1, 10},
        {10, 10, 10}
    };
    System.out.println("Test case 3: " + pa.pacificAtlantic(heights3));

    // Test case 4: Single row
    int[][] heights4 = {
        {1, 2, 3, 4, 5}
    };
    System.out.println("Test case 4: " + pa.pacificAtlantic(heights4));

    // Test case 5: Single column
    int[][] heights5 = {
        {1},
        {2},
        {3},
        {4},
        {5}
    };
    System.out.println("Test case 5: " + pa.pacificAtlantic(heights5));

    // Test case 6: Empty matrix
    int[][] heights6 = {};
    System.out.println("Test case 6: " + pa.pacificAtlantic(heights6));

    // Test case 7: Matrix with one cell
    int[][] heights7 = {
        {1}
    };
    System.out.println("Test case 7: " + pa.pacificAtlantic(heights7));

    // Test case 8: Large matrix with increasing heights
    int[][] heights8 = new int[100][100];
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            heights8[i][j] = i + j;
        }
    }
    System.out.println("Test case 8: " + pa.pacificAtlantic(heights8));

    }
}


 