package two_pointers.lc392_is_subsequence;

public class IsSubsequence {
    /*
     * Given two strings 's' and 't',
     * return true if s is a subsequence of t
     * or false otherwise
     * 
     * A subsequence of a string is a new string that is formed from the original
     * string
     * by deleting some (can be none) of the characters without disturbing the
     * relative positions
     * of the remaining characters. (i.e., "ace" is a subsequence of "abcde", while
     * "aec" is not).
     */

    public boolean isSubsequence(String s, String t) {
        /*
         * Use two pointers to iterate over t (looking for the characters in s)
         * one stays at the start, the other goes through all the characters
         * if the character at the right pointer isn't the same we continue until we
         * reach the length of t
         * return true if we find the subsequence
         * else false
         */

        if(s.isEmpty()) {
            return true;
        }

        if(t.isEmpty()) {
            return false;
        }

        int left = 0;
        int right = 0;

        while (right < t.length()) {
            if (right < t.length() && s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == s.length();
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        IsSubsequence is = new IsSubsequence();

        /* Example 1 - Expected Output: true */
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println(is.isSubsequence(s1, t1));

        /* Example 2 - Expected Output: false */
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println(is.isSubsequence(s2, t2));

        /* Edge Case 1 (same string) - Expected Output: true */
        String s3 = "hello";
        String t3 = "hello";
        System.out.println(is.isSubsequence(s3, t3));

        /* Edge Case 2 (s is empty) - Expected Output: true */
        String s4 = "";
        String t4 = "abc";
        System.out.println(is.isSubsequence(s4, t4));

        /* Edge Case 3 (t is empty) - Expected Output: false */
        String s5 = "abc";
        String t5 = "";
        System.out.println(is.isSubsequence(s5, t5));

        /* Edge Case 4 (both empty) - Expected Output: true */
        String s6 = "";
        String t6 = "";
        System.out.println(is.isSubsequence(s6, t6));

        /* Edge Case 5 (s longer than t) - Expected Output: false */
        String s7 = "abcdef";
        String t7 = "abc";
        System.out.println(is.isSubsequence(s7, t7));

        /* Edge Case 6 (case sensitivity) - Expected Output: false */
        String s8 = "A";
        String t8 = "a";
        System.out.println(is.isSubsequence(s8, t8));
    }
}