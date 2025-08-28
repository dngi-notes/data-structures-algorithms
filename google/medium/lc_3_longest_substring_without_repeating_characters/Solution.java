package google.medium.lc_3_longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string 's', find the length of the longest substring without repeating characters
 * 
 * e.g.
 * input: s = "abcabcbb"
 * output: 3
 * explanation: "abc" is non repeating, and length 3
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Set<Character> seen = new HashSet<>();

        int start = 0;
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            while (seen.contains(s.charAt(end))) {
                seen.remove(s.charAt(start));
                start++;
            }

            seen.add(s.charAt(end));
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("longest"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));

        /**
         * pwwkew
         *  ^
         *   ^
         */
    }
}