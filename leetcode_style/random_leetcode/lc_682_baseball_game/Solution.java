package random_leetcode.lc_682_baseball_game;

import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String operation : operations) {
            if (operation.equals("+")) {
                int number2 = stack.pop();
                int number1 = stack.peek();
                stack.push(number2);
                stack.push(number2 + number1);
            } else if (operation.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (operation.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(operation));
            }
        }

        int total = 0;
        for (int score : stack) {
            total += score;
        }

        return total;
    }
}

/**
 * operations[i]: the i_th operation
 * 
 * 
 * 
 * [5, 2, C, D, +]
 * 
 * 5, 2
 */