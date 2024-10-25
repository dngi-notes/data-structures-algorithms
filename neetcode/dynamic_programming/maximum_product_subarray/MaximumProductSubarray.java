package neetcode.dynamic_programming.maximum_product_subarray;

public class MaximumProductSubarray {
    /*
     * Given an integer array nums, find a subarray that has the largest product
     * within the array and return it.
     * 
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * 
     * You can assume the output will fit into a 32-bit integer.
     * 
     * AKA Kadane's Algorithm
     */
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int currentMax = 1;
        int currentMin = 1;

        for(int num : nums) {
            int temp = num * currentMax;
            currentMax = Math.max(Math.max(num * currentMax, num * currentMin), num);
            currentMin = Math.min(Math.min(temp, num * currentMin), num);
            result = Math.max(result, currentMax);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        String output = "Output: ";

        int[] nums1 = {1, 2, -3, 4};
        System.out.println(output + mps.maxProduct(nums1));
    }
}