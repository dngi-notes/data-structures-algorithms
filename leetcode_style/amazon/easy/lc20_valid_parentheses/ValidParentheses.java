package amazon.easy.lc20_valid_parentheses;

import java.util.*;

public class ValidParentheses {
    /*
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and
     * ']', determine if the input string is valid.
     * 
     * An input string is valid if:
     * 
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     */

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('}', '{');
        brackets.put(')', '(');
        brackets.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for(char bracket: s.toCharArray()) {
            if(brackets.containsKey(bracket)) {
                if(!stack.isEmpty() && brackets.get(bracket).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(bracket);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String output = "Output: ";

        String s1 = "()";
        System.out.println(output + vp.isValid(s1)); // expected true

        String s2 = "()[]{}";
        System.out.println(output + vp.isValid(s2)); // expected true

        String s3 = "(]";
        System.out.println(output + vp.isValid(s3)); // expected false

        String s4 = null;
        String s5 = "";
        String s6 = " ";

        System.out.println(output + vp.isValid(s4)); // expected false
        System.out.println(output + vp.isValid(s5)); // expected false
        System.out.println(output + vp.isValid(s6)); // expected false
    }
}
