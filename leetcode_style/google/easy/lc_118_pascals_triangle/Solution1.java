package google.easy.lc_118_pascals_triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    /**
     * Easiest: build a Triangle of Ones
     * given a positive integer n,
     * generate a triangle (list of lists)
     * with n rows where:
     * 
     * row 1 contains one 1
     * row 2 contains two 1s
     * row 3 contains three 1s
     * ...
     * row i contains i 1s
     * 
     * e.g:
     * n = 1
     * return: [[1]]
     * 
     * n = 4
     * return:
     * [
     * [1],
     * [1, 1],
     * [1, 1, 1],
     * [1, 1, 1, 1],]
     */
    public static List<List<Integer>> buildTriangle(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                row.add(1);
            }

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(buildTriangle(4));
    }
}
