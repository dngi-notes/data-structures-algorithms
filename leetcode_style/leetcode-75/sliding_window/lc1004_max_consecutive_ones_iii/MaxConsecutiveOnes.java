package sliding_window.lc1004_max_consecutive_ones_iii;

public class MaxConsecutiveOnes {
    /*
     * Given a binary array nums and an integer k,
     * return the maximum number of consecutive 1's in the array if you can flip at
     * most k 0s
     */

    public int longestOnes(int[] nums, int k) {
        /*
         * Initialize two pointers (left and right) to represent the window of the
         * current sequence of 1s.
         * Initialize a counter for the number of 0s in the current window.
         * Expand the window by moving the right pointer.
         * If a 0 is encountered, decrement k.
         * If k becomes negative, move the left pointer to shrink the window until k is
         * non-negative.
         * Keep track of the maximum length of the window.
         */

        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int left = 0;
        int right = 0;

        int longest = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
        String output = "Output: ";

        /* Example 1 - Expected Output: 6 */
        int[] nums1 = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k1 = 2;
        System.out.println(output + mco.longestOnes(nums1, k1));

        /* Exampel 2 - Expected Output: 10 */
        int[] nums2 = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k2 = 3;
        System.out.println(output + mco.longestOnes(nums2, k2));

        // Edge Case 1: Empty Array
        int[] nums3 = {};
        int k3 = 1;
        System.out.println("Edge Case 1: " + mco.longestOnes(nums3, k3)); // Expected Output: 0

        // Edge Case 2: Array with All Zeros
        int[] nums4 = { 0, 0, 0, 0 };
        int k4 = 2;
        System.out.println("Edge Case 2: " + mco.longestOnes(nums4, k4)); // Expected Output: 2

        // Edge Case 3: Array with All Ones
        int[] nums5 = { 1, 1, 1, 1 };
        int k5 = 0;
        System.out.println("Edge Case 3: " + mco.longestOnes(nums5, k5)); // Expected Output: 4

        // Edge Case 4: Array with No Zeros and k > 0
        int[] nums6 = { 1, 1, 1, 1 };
        int k6 = 2;
        System.out.println("Edge Case 4: " + mco.longestOnes(nums6, k6)); // Expected Output: 4

        // Edge Case 5: Array with Alternating Ones and Zeros
        int[] nums7 = { 1, 0, 1, 0, 1, 0, 1 };
        int k7 = 2;
        System.out.println("Edge Case 5: " + mco.longestOnes(nums7, k7)); // Expected Output: 5

        // Edge Case 6: Array with k Greater Than Length of Array
        int[] nums8 = { 1, 0, 1 };
        int k8 = 5;
        System.out.println("Edge Case 6: " + mco.longestOnes(nums8, k8)); // Expected Output: 3

        // Edge Case 7: Array with k Equal to Zero
        int[] nums9 = { 1, 0, 1, 0, 1 };
        int k9 = 0;
        System.out.println("Edge Case 7: " + mco.longestOnes(nums9, k9)); // Expected Output: 1

        // Edge Case 8: Array with k Equal to Length of Array
        int[] nums10 = { 0, 0, 0, 0 };
        int k10 = 4;
        System.out.println("Edge Case 8: " + mco.longestOnes(nums10, k10)); // Expected Output: 4
    }
}
