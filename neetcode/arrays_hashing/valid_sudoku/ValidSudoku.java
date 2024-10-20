package neetcode.arrays_hashing.valid_sudoku;

import java.util.*;

public class ValidSudoku {
    /*
     * You are given a 9 x 9 Sudoku board `board`.
     * A Sudoku board is valid if the following rules are followed
     * 
     * 1. Each row must contain the digits `1-9` with duplicates
     * 2. Each column must contain the digits `1-9` without duplicates
     * 3. Each of the nine `3 x 3` sub-boxes of the grid must contain the digits 1-9
     * without duplicates
     * 
     * Return true if the Sudoku board is valid, otherwise return false
     * 
     * Note: A board doesn't need to be full or solvable to be valid
     */

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> boxes = new HashSet<>();

            for(int j = 0; j < 9; j++) {
                char row = board[i][j];
                char col = board[j][i];
                char box = board[3 * (i / 3) + (j / 3)][3 * (i % 3) + (j % 3)];

                if(row != '.') {
                    if(rows.contains(row)) {
                        return false;
                    } else {
                        rows.add(row);
                    }
                }

                if(col != '.') {
                    if(cols.contains(col)) {
                        return false;
                    }  else {
                        cols.add(col);
                    }
                }

                if(box != '.') {
                    if(boxes.contains(box)) {
                        return false;
                    } else {
                        rows.add(row);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        String output = "Output: ";

        char[][] board1 = {
            {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
            {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
            {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
            {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(output + vs.isValidSudoku(board1));
    }
}