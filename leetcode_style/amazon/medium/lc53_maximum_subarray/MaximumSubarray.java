package amazon.medium.lc53_maximum_subarray;

public class MaximumSubarray {
    /*
     * Given an integer array nums, find the subarray,
     * with the largest sum, and return its sum.
     * 
     * Given an integer array nums, find the
     * subarray
     * with the largest sum, and return its sum.
     * 
     * Example 1:
     * 
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     * Example 2:
     * 
     * Input: nums = [1]
     * Output: 1
     * Explanation: The subarray [1] has the largest sum 1.
     * Example 3:
     * 
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
     */
    public int maxSubArray(int[] nums) {
        /*
         * Intuition:
         * keep track of the current sum and the max sum
         * if the sum ever becomes negative, reset back to zero and continue
         * max sum will always be the max of maxSum and currentSum
         */

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        String output = "Output: ";

        int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(output + ms.maxSubArray(nums1)); // expected: 6

        int[] nums2 = { 1 };
        System.out.println(output + ms.maxSubArray(nums2)); // expected: 1

        int[] nums3 = { 5, 4, -1, 7, 8};
        System.out.println(output + ms.maxSubArray(nums3)); // expected: 23
    }
}
