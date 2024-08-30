package sliding_window.lc643_maximum_average_subarray_i;

public class MaxAverage {
    /*
     * You are given an integer array nums consisting of 'n' elements, and an integer 'k'
     * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value
     * Any answer with a calculation error less than 10^-5 will be accepted
     */

     public double findMaxAverage(int[] nums, int k) {
        /**
         * define the pointers used to create a window of size k
         * average all the numbers within the window
         * and keep track of max average
         * once we've looped over everything
         * return the maxAverage
         */

        int currentSum = 0;
        for(int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int maxSum = currentSum;
        for(int right = k; right < nums.length; right++) {
            currentSum += nums[right] - nums[right - k];
            maxSum = Math.max(currentSum, maxSum);
         }
         return (double) maxSum / k;
     }

     public static void main(String[] args) {
        MaxAverage ma = new MaxAverage();

        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.println(ma.findMaxAverage(nums1, k1));

        int[] nums2 = {5};
        int k2 = 1;
        System.out.println(ma.findMaxAverage(nums2, k2));

        
     }
}
