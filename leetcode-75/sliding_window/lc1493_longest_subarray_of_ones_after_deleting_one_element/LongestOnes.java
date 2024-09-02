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
         * if there are no zeros, just remove the first element
         * if there are no ones just remove the first element
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
}
