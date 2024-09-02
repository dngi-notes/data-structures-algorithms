package sliding_window.lc1493_longest_subarray_of_ones_after_deleting_one_element;

public class LongestOnes {
    /*
     * given a binary array nums, you should delete one element from it.
     * return the size of the longest non-empty subarray containing only 1's in the
     * resulting array
     * return 0, if there is no such subarray
     */

    public int longestSubarray(int[] nums) {
        /*
         * base case: return 0 if there is no such subarray
         * 
         * find the longest subarray of ones
         * try to extend it by removing a zero
         * 
         * 
         * return the length
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

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest - 1;
    }

    public static void main(String[] args) {
        LongestOnes lo = new LongestOnes();
        String output = "Output: ";

        /* Example 1 */
        int[] nums1 = { 1, 1, 0, 1 };
        System.out.println(output + lo.longestSubarray(nums1)); // Expected output: 3

        /* Example 2 */
        int[] nums2 = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println(output + lo.longestSubarray(nums2)); // Expected output: 5

        /* Edge Case 1 (all ones) */
        int[] nums3 = { 1, 1, 1 };
        System.out.println(output + lo.longestSubarray(nums3)); // Expected output: 2

        /* Edge Case 2 (all zeros) */
        int[] nums4 = { 0, 0, 0 };
        System.out.println(output + lo.longestSubarray(nums4)); // Expected output: 0

        /* Edge Case 3 (single element 1) */
        int[] nums5 = { 1 };
        System.out.println(output + lo.longestSubarray(nums5)); // Expected output: 0

        /* Edge Case 4 (single element 0) */
        int[] nums6 = { 0 };
        System.out.println(output + lo.longestSubarray(nums6)); // Expected output: 0

        /* Edge Case 5 (empty array) */
        int[] nums7 = {};
        System.out.println(output + lo.longestSubarray(nums7)); // Expected output: 0

        /* Edge Case 6 (one zero in the middle) */
        int[] nums8 = { 1, 1, 1, 0, 1, 1, 1 };
        System.out.println(output + lo.longestSubarray(nums8)); // Expected output: 6

        /* Edge Case 7 (multiple zeros) */
        int[] nums9 = { 1, 0, 1, 0, 1, 0, 1 };
        System.out.println(output + lo.longestSubarray(nums9)); // Expected output: 2

        /* Edge Case 8 (zeros at the ends) */
        int[] nums10 = { 0, 1, 1, 1, 0 };
        System.out.println(output + lo.longestSubarray(nums10)); // Expected output: 3

        /* Edge Case 9 (alternating ones and zeros) */
        int[] nums11 = { 1, 0, 1, 0, 1, 0, 1, 0 };
        System.out.println(output + lo.longestSubarray(nums11)); // Expected output: 2
    }
}
