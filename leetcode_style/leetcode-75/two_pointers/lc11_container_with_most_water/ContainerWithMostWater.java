package two_pointers.lc11_container_with_most_water;

public class ContainerWithMostWater {
    /**
     * You are given an integer array height of length n. There are n vertical lines
     * drawn such that the two endpoints of the ith line are (i, 0) and (i,
     * height[i]).
     * Find two lines that together with the x-axis form a container, such that the
     * container contains the most water.
     * Return the maximum amount of water a container can store.
     */
    public int maxArea(int[] height) {
        /*
         * have two pointers, one one the left side (index 0) and another on the far
         * right(length - 1)
         * keep track of the maxArea
         * return the maxArea
         */
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int containerLength = right - left;
            int area = containerLength * Math.min(height[left], height[right]);

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();

        /* Example 1 - Expected Output: 49 */
        int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(cwmw.maxArea(height1));

        /* Example 2 - Expected Output: 1 */
        int[] height2 = { 1, 1 };
        System.out.println(cwmw.maxArea(height2));

        /* Edge Case 1 - Empty Array - Expected Output: 0 */
        int[] height3 = {};
        System.out.println(cwmw.maxArea(height3));

        /* Edge Case 2 - Single Element Array - Expected Output: 0 */
        int[] height4 = { 5 };
        System.out.println(cwmw.maxArea(height4));

        /* Edge Case 3 - All Elements Same Height - Expected Output: 16 */
        int[] height5 = { 4, 4, 4, 4, 4 };
        System.out.println(cwmw.maxArea(height5));

        /* Edge Case 4 - Decreasing Heights - Expected Output: 9 */
        int[] height6 = { 5, 4, 3, 2, 1 };
        System.out.println(cwmw.maxArea(height6));

        /* Edge Case 5 - Increasing Heights - Expected Output: 9 */
        int[] height7 = { 1, 2, 3, 4, 5 };
        System.out.println(cwmw.maxArea(height7));
    }

}
