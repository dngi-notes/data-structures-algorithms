package two_pointers.lc392_is_subsequence;

public class IsSubsequence {
    /*
     * Given two strings 's' and 't', 
     * return true if s is a subsequence of t
     * or false otherwise
     * 
     * A subsequence of a string is a new string that is formed from the original string
     * by deleting some (can be none) of the characters without disturbing the relative positions
     * of the remaining characters. (i.e., "ace" is a subsequence of "abcde", while "aec" is not).
     */

     public boolean isSubsequence(String s, String t) {
        /*
         * Use two pointers to iterate over t (looking for the characters in s)
         * one stays at the start, the other goes through all the characters
         * if the character at the right pointer isn't the same we continue until we reach the length of t
         * return true if we find the subsequence
         * else false
         */

         
     }
}