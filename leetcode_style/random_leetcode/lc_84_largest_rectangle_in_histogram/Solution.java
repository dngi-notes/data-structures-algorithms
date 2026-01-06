package random_leetcode.lc_84_largest_rectangle_in_histogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}

/**
 * Input: heights = [2,1,5,6,2,3]
 *                   ^
 *                     ^
 * 
 * Output: 10
 * 
 * stack will contain indices e.g. stack.push(i)
 */