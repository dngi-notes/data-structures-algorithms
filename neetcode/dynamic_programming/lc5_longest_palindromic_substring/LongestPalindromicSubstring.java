package neetcode.dynamic_programming.lc5_longest_palindromic_substring;

public class LongestPalindromicSubstring {
    /*
     * Given a string s, return the longest
     * palindromic substring in s.
     */
    public String longestPalindrome(String s) {
        int n = s.length();

        if (n < 2) {
            return s;
        }

        boolean[][] memo = new boolean[n][n];
        int sIndex = 0;
        int maxLength = 1;

        /*
         * Three Subproblems:
         * 1. substrings of length 1 are always palindromes
         * 2. substrings of length 2 are palindromes if the two characters are the same
         * 3. substrings of length 3 are palindromes if the at least the left and right
         * character are the same
         */

        // subproblem 1
        for (int i = 0; i < n; i++) {
            memo[i][i] = true;
        }

        // subproblem 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                memo[i][i + 1] = true;
                sIndex = i;
                maxLength = 2;
            }
        }

        // subproblem 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;

                if(s.charAt(i) == s.charAt(j) && memo[i + 1][j - 1]) {
                    memo[i][j] = true;

                    if(len > maxLength) {
                        sIndex = i;
                        maxLength = len;
                    }
                }
            }
        }
        return s.substring(sIndex, sIndex + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String output = "Output: ";

        System.out.println(output + lps.longestPalindrome("babad")); // expected bab
        System.out.println(output + lps.longestPalindrome("cbbd")); // expected bb

        System.out.println(output + lps.longestPalindrome("a")); // expected a
        System.out.println(output + lps.longestPalindrome("")); // expected ""
        System.out.println(output + lps.longestPalindrome("aacabdkacaa")); // expected "aca"

    }
}
