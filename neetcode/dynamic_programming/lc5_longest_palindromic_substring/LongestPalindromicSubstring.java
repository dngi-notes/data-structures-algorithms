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
                        maxLength = j - i + 1;
                        sIndex = i;
                    }

                } else {
                    memo[i] = false;
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
