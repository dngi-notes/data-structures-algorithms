package neetcode.graphs.surrounded_regions;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    /*
     * You are given an m x n matrix board containing letters 'X' and 'O', capture
     * regions that are surrounded:
     * 
     * Connect: A cell is connected to adjacent cells horizontally or vertically.
     * Region: To form a region connect every 'O' cell.
     * Surround: The region is surrounded with 'X' cells if you can connect the
     * region with 'X' cells and none of the region cells are on the edge of the
     * board.
     * 
     * A surrounded region is captured by replacing all 'O's with 'X's in the input
     * matrix board.
     */
    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }

        Queue<int[]> oQueue = new LinkedList<>();
        int rows = board.length;
        int cols = board[0].length;

        for(int r = 0; r < rows; r++) {
            if(board[r][0] == 'O') oQueue.offer(new int[]{r, 0});
            if(board[r][cols - 1] == 'O') oQueue.offer(new int[]{r, cols - 1});
        }

        for(int c = 0; c < cols; c++) {
            if(board[0][c] == 'O') oQueue.offer(new int[]{0, c});
            if(board[rows - 1][c] == 'O') oQueue.offer(new int[]{rows - 1, c});
        }

        bfs(board, oQueue);

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if(board[r][c] == 'E') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    /*
     * Time Complexity O(m * n)
     * Space Complexity O(m * n)
     */

    private void bfs(char[][] board, Queue<int[]> oQueue) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!oQueue.isEmpty()) {
            int[] cell = oQueue.poll();
            int row = cell[0];
            int col = cell[1];

            if(row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') {
                continue;
            }

            board[row][col] = 'E';

            for(int[] direction: directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] == 'O') {
                    oQueue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        String output = "Output: ";


    }
}