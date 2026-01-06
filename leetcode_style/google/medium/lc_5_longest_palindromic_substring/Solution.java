package google.medium.lc_5_longest_palindromic_substring;

/**
 * given a string 's', return the longest palindromic substring in 's'
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return "";

        int n = s.length();
        boolean[][] cache = new boolean[n][n];
        int maxLength = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            cache[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cache[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && cache[i + 1][j - 1]) {
                    cache[i][j] = true;

                    if (len > maxLength) {
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    // public String longestPalindrome(String s) {
    // if (s == null || s.isEmpty()) return "";

    // String longest = "";
    // int n = s.length();
    // Boolean[][] cache = new Boolean[n][n];

    // for (int i = 0; i < n; i++) {
    // for (int j = i; j < n; j++) {
    // if (isPalindrome(cache, s, i, j)) {
    // String candidate = s.substring(i, j + 1);
    // if (candidate.length() > longest.length()) {
    // longest = candidate;
    // }
    // }
    // }
    // }
    // return longest;
    // }

    // private boolean isPalindrome(Boolean[][] cache, String s, int start, int end)
    // {
    // if (start >= end) return true;
    // if (cache[start][end] != null) return cache[start][end];

    // cache[start][end] = s.charAt(start) == s.charAt(end) && isPalindrome(cache,
    // s, start + 1, end - 1);
    // return cache[start][end];
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("leetcode")); // expected ee
        System.out.println(s.longestPalindrome("abbbaa")); // expected abbba
    }
}
