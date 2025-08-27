package google.easy.lc_387_first_unique_character_in_string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a string s, find the first non-repeating character in it and return its
 * index. If it does not exist, return -1.
 * 
 * e.g.
 * Input: s = "leetcode"
 * output: 0, because 'l' is the first character that doesnt repeat and it occurs at index 0
 */
public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        Map<Character, Integer> sFreq = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            sFreq.put(ch, sFreq.getOrDefault(ch, 0) + 1);
            q.offer(ch);
        }

        while (!q.isEmpty()) {
            char ch = q.peek();
            if (sFreq.containsKey(ch) && sFreq.get(ch) == 1) {
                return s.indexOf(ch);
            } else {
                q.poll();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstUniqChar("leetcode")); // expected: 0
        System.out.println(s.firstUniqChar("loveleetcode")); // expected: 2
        System.out.println(s.firstUniqChar("aabb")); // expected: -1
    }
}
