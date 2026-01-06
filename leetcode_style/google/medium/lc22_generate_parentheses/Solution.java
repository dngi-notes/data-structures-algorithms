package google.medium.lc22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given 'n' pairs of parentheses, write a function to generate all combinations of well-formed parentheses
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<Character> brackets = new Stack<>();
        
        dfs(n, result, brackets, 0, 0);
        return result;
    }

    private void dfs(int n, List<String> parentheses, Stack<Character> brackets, int open, int closed) {
        if (open == closed && open == n) {
            StringBuilder sb = new StringBuilder();

            for (char bracket : brackets) {
                sb.append(bracket);
            }

            parentheses.add(sb.toString());
            return;
        }

        if (open < n) {
            brackets.push('(');
            dfs(n, parentheses, brackets, open + 1, closed);
            brackets.pop();
        }

        if (open > closed) {
            brackets.push(')');
            dfs(n, parentheses, brackets, open, closed + 1);
            brackets.pop();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
        System.out.println(s.generateParenthesis(1));
        System.out.println(s.generateParenthesis(0));
    }
}
