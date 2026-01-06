package neetcode.stacks.lc22_generate_parentheses;

import java.util.*;

public class GenerateParentheses {
    /*
     * You are given an integer n. Return all well-formed parentheses strings that
     * you can generate with n pairs of parentheses.
     */
    public List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        backtrack(0, 0, n, res, stack);

        return res;
    }

    private void backtrack(int open, int closed, int n, List<String> res, Stack<Character> stack) {
        if (open == closed && open == n) {

            StringBuilder sb = new StringBuilder();
            for (char ch : stack) {
                sb.append(ch);
            }

            res.add(sb.toString());
            return;
        }

        if (open < closed) {
            stack.push('(');
            backtrack(open + 1, closed, n, res, stack);
            stack.pop();
        }

        if (closed < open) {
            stack.push(')');
            backtrack(open, closed + 1, n, res, stack);
            stack.pop();
        }
    }
}
