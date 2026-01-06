package google.medium.lc_36_valid_sudoku;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
 * without repetition.
 * 
 */
public class Solution {
    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        Map<Integer, Set<Character>> rowToValue = new HashMap<>();
        Map<Integer, Set<Character>> colToValue = new HashMap<>();
        Map<String, Set<Character>> squareToValue = new HashMap<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                String squareKey = new StringBuilder().append(row / 3).append(',').append(col / 3).toString();
                if (rowToValue.computeIfAbsent(row, key -> new HashSet<>()).contains(board[row][col]) ||
                    colToValue.computeIfAbsent(col, key -> new HashSet<>()).contains(board[row][col]) ||
                    squareToValue.computeIfAbsent(squareKey, key -> new HashSet<>()).contains(board[row][col])
                ) {
                    return false;
                }

                rowToValue.get(row).add(board[row][col]);
                colToValue.get(col).add(board[row][col]);
                squareToValue.get(squareKey).add(board[row][col]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}})); // expected: true

        System.out.println(isValidSudoku(new char[][]{
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '9', '9'}})); // expected: false
    }
}
