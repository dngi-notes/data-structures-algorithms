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
                stack.pop();
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

    public static void main(String[] args) {
        RemoveStars rs = new RemoveStars();
        String output = "Output: ";

        String s1 = "leet**cod*e";
        System.out.println(output + rs.removeStars(s1));
    }
}