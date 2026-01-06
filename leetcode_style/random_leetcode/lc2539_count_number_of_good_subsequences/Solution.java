package random_leetcode.lc2539_count_number_of_good_subsequences;

import java.util.Arrays;

public class Solution {
    
    /**
     * the original problem was too hard so i solved 3 easier problems to learn how to do it
     * 1. finding all subsequences
     * 2. finding all subsequences ending with a character 'ch'
     * 3. finding all unique subsequences (no repeating characters in a subsequence)
    */
   public int countAll(String s) {
       if (s == null || s.isEmpty()) {
           return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = 2 * dp[i - 1];
        }
        
        return dp[s.length()] - 1;
    }
    
    
    public int[] countEnd(String s) {
        if (s == null || s.isEmpty()) {
            return new int[0];
        }
        
        int[] end = new int[26];
        long total = 1;
        
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            
            long newCount = total;
            total += newCount;
            end[idx] += (int) newCount;
        }
        
        return end;
    }
    
    public int countUnique(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int[] end = new int[26];
        long total = 1;
        
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            
            long newCount = total - end[idx];
            end[idx] += (int) newCount;
            total += newCount;
        }
        
        return (int) (total - 1);
    }
    /*
     * LeetCode Problem: Count Number of Good Subsequences
     * 
     * You are given a string s consisting of lowercase English letters.
     * 
     * A subsequence of s is called good if:
     * 1. It does not contain duplicate characters (each character appears at most
     * once).
     * 2. It is non-empty.
     * 
     * Your task is to return the number of distinct good subsequences of s.
     * Two subsequences are considered distinct if the sequences of characters
     * differ
     * (not by their indices).
     * 
     * Since the answer may be large, return it modulo 10^9 + 7.
     * 
     * Example 1:
     * Input:
     * s = "abc"
     * Output:
     * 7
     * Explanation:
     * All non-empty subsequences without repeated characters:
     * "a", "b", "c", "ab", "ac", "bc", "abc"
     * Total = 7.
     * 
     * Example 2:
     * Input:
     * s = "aba"
     * Output:
     * 6
     * Explanation:
     * Distinct good subsequences are:
     * "a", "b", "ab", "ba", "a"
     * (Duplicates removed)
     * Total = 6.
     * 
     * Constraints:
     * 1 ≤ s.length ≤ 2 × 10^5
     * s consists only of lowercase English letters.
     */
    public int countGoodSubsequences(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final int MOD = 1000000007;
        int[] end = new int[26];
        long total = 1;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            long newCount = (total - end[idx] + MOD) % MOD;
            end[idx] = (int) ((end[idx] + newCount) % MOD);
            total = total + (total + newCount) % MOD;
        }

        return (int) total - 1;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String s1 = "aba";
        System.out.println(sol.countAll(s1)); // expected 7
        System.out.println(Arrays.toString(sol.countEnd(s1))); // expected [1, 2, 4, 0, 0...]
        System.out.println(sol.countUnique(s1));
        System.out.println(sol.countGoodSubsequences(s1));
    }
}
