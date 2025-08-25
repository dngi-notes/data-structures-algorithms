package google.lc_242_valid_anagram;

/**
 * Given two strings s and t, return true if t is an of s, and false otherwise.
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * 
 * Output: true
 * Example 2:
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return false;
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[] freq = new int[26];
        for (int i = 0; i < sChars.length; i++) {
            freq[sChars[i] - 'a']++;
            freq[tChars[i] - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isAnagram("anagram", "nagaram"));
        System.out.println(s.isAnagram("rat", "car"));
    }
}
