package neetcode.stacks.lc84_largest_rectangle_in_histogram;

import java.util.*;

public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
     
        Stack<Integer> bars = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while(!bars.isEmpty() && currentHeight < heights[bars.peek()]) {
                int height = heights[bars.pop()];
                int width = bars.isEmpty() ? i : i - bars.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            bars.push(i);
        }

        return maxArea;
    }
}