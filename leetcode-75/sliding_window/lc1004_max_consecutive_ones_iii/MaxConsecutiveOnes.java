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

        if(nums.length == 0 || nums == null || k > nums.length) {
            return 0;
        }

        int left = 0;
        int right = 0;

        int longest = 0;
        int zeroCount = 0;

        while(right < nums.length) {
            if(nums[right] == 0) {
                zeroCount++;
            }

            while(zeroCount > k) {
                if(nums[left] == 0) {
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
        int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        System.out.println(output + mco.longestOnes(nums1, k1));

        /* Exampel 2 - Expected Output: 10 */
        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k2 = 3;
        System.out.println(output + mco.longestOnes(nums2, k2));
    }
}
