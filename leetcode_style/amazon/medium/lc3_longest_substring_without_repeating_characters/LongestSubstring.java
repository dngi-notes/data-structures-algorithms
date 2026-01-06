package amazon.medium.lc3_longest_substring_without_repeating_characters;

import java.util.Set;
import java.util.HashSet;

public class LongestSubstring {
    /*
     * Given a string s, find the length of the longest
     * substring
     * without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int lengthOfLongest = 0;

        Set<Character> charSet = new HashSet<>();
        for(int right = 0; right < s.length(); right++) {
            while(charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            lengthOfLongest = Math.max(lengthOfLongest, right - left + 1);
        }

        return lengthOfLongest;
    }

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        String output = "Output: ";

        System.out.println(output + ls.lengthOfLongestSubstring("abcabcbb")); // expected: "3"
        System.out.println(output + ls.lengthOfLongestSubstring("bbbbb")); // expected: "1"
        System.out.println(output + ls.lengthOfLongestSubstring("pwwkew")); // expected: "3"
        System.out.println(output + ls.lengthOfLongestSubstring(null)); // expected: "0"
        System.out.println(output + ls.lengthOfLongestSubstring("")); // expected: "0"
    }
}
