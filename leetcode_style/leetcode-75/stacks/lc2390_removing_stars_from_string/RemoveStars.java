package stacks.lc2390_removing_stars_from_string;

import java.util.Stack;

public class RemoveStars {
    /*
     * You are given a string s, which contains '*'
     * 
     * In one operation, you can:
     * -> choose a star in s
     * -> remove the closest non-star character to its left, as well as remove the
     * star itself
     * 
     * return the string after all stars have been removed.
     * 
     * Note:
     * The input will be generated such that the operation is always possible
     * It can be shown that the resulting string will always be unique
     */
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(ch == '*') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(ch);
        }

        StringBuilder result = new StringBuilder();
        for(char ch: stack) {
            result.append(ch);
        }

        return result.toString();
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static void main(String[] args) {
        RemoveStars rs = new RemoveStars();
        String output = "Output: ";

        /* example 1 */
        String s1 = "leet**cod*e";
        System.out.println(output + rs.removeStars(s1)); // expected: "lecoe"

        /* example 2 */
        String s2 = "erase*****";
        System.out.println(output + rs.removeStars(s2)); // expected: ""
        
        String s3 = "a*b*c*";
        System.out.println(output + rs.removeStars(s3)); // Expected output: ""

        String s4 = "abc*de**f";
        System.out.println(output + rs.removeStars(s4)); // Expected output: "abf"

        String s5 = "*****";
        System.out.println(output + rs.removeStars(s5)); // Expected output: ""

        String s6 = "no*stars*here";
        System.out.println(output + rs.removeStars(s6)); // Expected output: "nstarshere"

        String s7 = "";
        System.out.println(output + rs.removeStars(s7)); // Expected output: ""

        String s8 = "*a*b*c*";
        System.out.println(output + rs.removeStars(s8)); // Expected output: ""

        String s9 = "a**b**c";
        System.out.println(output + rs.removeStars(s9)); // Expected output: "c"

        String s10 = "a*b*c*d*e*f*";
        System.out.println(output + rs.removeStars(s10)); // Expected output: ""

    }
}