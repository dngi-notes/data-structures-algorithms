package neetcode.graphs.lc417_pacific_atlantic_water_flow;

import java.util.List;

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
         * initialise our result list
         * create 2D boolean arrays to handle if the pacific or atlantic is reachable
         * from that point
         * 
         * create queues for both the pacific and the atlantic
         * 
         * iterate over the rows and columns of the grid
         * to define atlantic and pacific borders
         * 
         * perform bfs on both oceans
         * loop over the rows and columns again.
         * if the pacific and atlantic are both reachable, then we can add the r, c position to our result
         * 
         * 
         * return result
         */
    }
}