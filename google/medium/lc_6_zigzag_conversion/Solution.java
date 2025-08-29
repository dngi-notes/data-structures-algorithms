package google.medium.lc_6_zigzag_conversion;

import java.util.Arrays;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N
 * A P L S I I G
 * Y I R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * Example 2:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P I N
 * A L S I G
 * Y A H R
 * P I
 * 
 * Example 3:
 * 
 * Input: s = "A", numRows = 1
 * Output: "A"
 * 
 */

public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) return "";
        if (s.length() == 1 || numRows == 1) return s;

        char[] str1 = s.toCharArray();
        int len = s.length();

        String[] arr = new String[numRows];
        Arrays.fill(arr, "");

        int row = 0;
        boolean down = true;

        for (int i = 0; i < len; i++) {
            arr[row] += str1[i];
            if (row == numRows - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }

            if (down) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(arr[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("PAYPALISHIRING", 3));
    }
}