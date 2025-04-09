package neetcode.backtracking.n_queens;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> result = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = '.';
            }

        }
        
        backtrack(board, n, 0, result);
        return result;
    }

    private static void backtrack(char[][] board, int n, int row, List<List<String>> result) {
        if (row == n) {
            result.add(new ArrayList<>(createSolution(board)));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, n, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static List<String> createSolution(char[][] board) {
        List<String> solution = new ArrayList<>();

        for (int r = 0; r < board.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < board[0].length; c++) {
                sb.append(board[r][c]);
            }
            solution.add(sb.toString());
        }

        return solution;
    }
}