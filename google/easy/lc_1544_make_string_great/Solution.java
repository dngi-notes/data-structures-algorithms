package google.easy.lc_1544_make_string_great;

import java.util.Stack;

/**
 * Given a string s of lower and upper case English letters.
 * 
 * A good string is a string which doesn't have two adjacent characters s[i] and
 * s[i + 1] where:
 * 
 * 0 <= i <= s.length - 2
 * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case
 * or vice-versa.
 * 
 * To make the string good, you can choose two adjacent characters that make the
 * string bad and remove them. You can keep doing this until the string becomes
 * good.
 * 
 * Return the string after making it good. The answer is guaranteed to be unique
 * under the given constraints.
 * 
 * Notice that an empty string is also good.
 * 
 * e.g.
 * Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
 */

public class Solution {
    public String makeGood(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.makeGood("leEeetcode"));
        System.out.println(s.makeGood("abBAcC"));
    }
}
