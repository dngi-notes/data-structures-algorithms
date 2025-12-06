package google.easy.lc_118_pascals_triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static List<List<Integer>> buildTriangle(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) return result;

        for (int i = 1; i <= n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                row.add(j);
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(buildTriangle(4));
    }
}