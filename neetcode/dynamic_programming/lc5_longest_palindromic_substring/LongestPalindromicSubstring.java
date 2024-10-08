package neetcode.dynamic_programming.lc5_longest_palindromic_substring;

public class LongestPalindromicSubstring {
    /*
     * Given a string s, return the longest
     * palindromic substring in s.
     */
    public String longestPalindrome(String s) {
        int n = s.length();

        if(n < 2) {
            return s;
        }

        boolean[] memo = new boolean[n];
        int sIndex = 0;
        int maxLength = 1;

        for(int j = 1; j < n; j++) {
            for(int i = j; i >= 0; i--) {
                if(s.charAt(j) == s.charAt(i)) {
                    memo[i] = true;

                    if(j - i + 1 > maxLength) {
                        sIndex = i;
                        maxLength = j - i + 1;
                    }

                } else {
                    memo[i] = false;
                }
            }
        }

        return s.substring(sIndex, sIndex + maxLength);
    }
}
