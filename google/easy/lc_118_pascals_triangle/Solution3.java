package google.easy.lc_118_pascals_triangle;

import java.util.*;

public class Solution3 {
    public static List<List<Integer>> buildTriangle(int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (n == 0) return triangle;

        for (int i = 1; i <= n; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j <= i - 2; j++) {
                row.add(i);
            }
            if (i > 1) {
                row.add(1);
            }

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(buildTriangle(5));        
    }
}
