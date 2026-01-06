package amazon.medium.lc5_longest_palindromic_substring;

public class LongestPalindrome {
    /*
     * Given a string s, return the longest
     * palindromic substring in s.
     * 
     * (A string is palindromic if it reads the same forward and backward.)
     * 
     * Example 1:
     * 
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     * 
     * Input: s = "cbbd"
     * Output: "bb" 
     */

    public String longestPalindrome(String s) {
        int n = s.length();
        
        if(n < 2) {
            return s;
        }

        boolean[][] memo = new boolean[n][n];
        int startIndex = 0;
        int maxLength = 1;

        for(int i = 0; i < n; i++) {
            memo[i][i] = true;
        }

        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                memo[i][i + 1] = true;
                startIndex = i;
                maxLength = 2;
            }
        }

        for(int len = 3; len <= n; len++) {
            for(int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && memo[i + 1][j - 1]) {
                    memo[i][j] = true;
                    
                    if(len > maxLength) {
                        startIndex = i;
                        maxLength = len;
                    }
                }
            }
        }

        int endIndex = startIndex + maxLength;
        return s.substring(startIndex, endIndex);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String output = "Output: ";

        System.out.println(output + longestPalindrome.longestPalindrome("babad")); // expected bab / aba
        System.out.println(output + longestPalindrome.longestPalindrome("cbbd")); // expected bb
        System.out.println(output + longestPalindrome.longestPalindrome("abcccccddababd")); // expected bb
        System.out.println(output + longestPalindrome.longestPalindrome("")); // expected bb
    }
}
