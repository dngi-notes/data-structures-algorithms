package neetcode.dynamic_programming.lc647_palindromic_substrings;

public class PalindromicSubstrings {
    /*
     * Given a string s, return the number of palindromic substrings in it.
     * 
     * A string is a palindrome when it reads the same backward as forward.
     * 
     * A substring is a contiguous sequence of characters within the string.
     */
    public int countSubstrings(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }

        int n = s.length();
        if(n < 2) {
            return 1;
        }

        boolean[][] memo = new boolean[n][n];
        int startIndex = 0;
        int maxLength = 1;
        int totalSubstrings = 0;
        
        for(int i = 0; i < n; i++) {
            memo[i][i] = true;
            totalSubstrings++;
        }

        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                memo[i][i+1] = true;
                startIndex = i;
                maxLength = 2;
                totalSubstrings++;
            }
        }

        for(int len = 3; len <= n; len++) {
            for(int i = 0; i < len - n + 1; i++) {
                int j = i + len - 1;

                if(s.charAt(i) == s.charAt(j) && memo[i + 1][j - 1]) {
                    memo[i][j] = true;

                    if(len > maxLength) {
                        startIndex = i;
                        maxLength = len;
                        totalSubstrings++;
                    }
                }
            }
        }

        return totalSubstrings;
    }

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        String output = "Output: ";

        System.out.println(output + ps.countSubstrings("abc")); // expected 3
        System.out.println(output + ps.countSubstrings("aaa")); // expected 6
        System.out.println(output + ps.countSubstrings("aacabdkacaa")); // expected 14
        
    }
}
