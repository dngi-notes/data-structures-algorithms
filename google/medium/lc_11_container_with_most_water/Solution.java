package google.medium.lc_11_container_with_most_water;

/**
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * e.g.
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array
 * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 */
public class Solution {
    public int maxArea(int[] heights) {
        if (heights == null || heights.length <= 1) return 0;

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = width * height;
            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 3, 8, 3, 7})); // expected: 49
        System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 3, 8, 3, 8})); // expected: 56
        System.out.println(s.maxArea(new int[]{1, 1})); // expected: 1
        System.out.println(s.maxArea(null)); // expected: 0
        System.out.println(s.maxArea(new int[]{})); // expected: 0
        System.out.println(s.maxArea(new int[]{1})); // expected: 0
    }
}
