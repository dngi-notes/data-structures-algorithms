package random_leetcode.maximum_product_subarray;

/**
 * Given an integer array nums, find a subarray that has the largest product
 * within the array and return it.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * You can assume the output will fit into a 32-bit integer.
 * 
 * e.g:
 * -----
 * input: [1, 2, -3, 4] | output: 4
 * -----
 */

public class Solution {
    public static int maxProduct(int[] nums) {
        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            res = Math.max(res, cur);
            for (int j = i + 1; j < nums.length; j++) {
                cur *= nums[j];
                res = Math.max(res, cur);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1, 2, -3, 4}));
    }
}
