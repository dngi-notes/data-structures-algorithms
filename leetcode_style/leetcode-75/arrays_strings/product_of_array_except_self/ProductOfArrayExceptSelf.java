
package arrays_strings.product_of_array_except_self;

import java.util.Arrays;
/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
p * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
ub *
lic * You must write an algorithm that runs in O(n) time and without using the division operation. */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        /*
         * Create an array of size nums
         * prefix and suffix variable both equal to 1 to use in result array
         * 
         */

         int[] result = new int[nums.length];
         int prefix = 1;
         int postfix = 1;
        
         for(int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
         }

         for(int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
         }

         return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf poaes = new ProductOfArrayExceptSelf();

        /* Example 1 - Expected Output: [24, 12, 8, 6] */
        int[] nums = {1, 2, 3, 4};
        int[] result = poaes.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));

        /* Example Case (with negative numbers) - Expected Output: [0, 0, 9, 0, 0] */
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = poaes.productExceptSelf(nums2);
        System.out.println(Arrays.toString(result2));

        /* Edge Case 1 (array of length 1) - Expected Output: = [1] */
        int[] nums3 = {3};
        int[] result3 = poaes.productExceptSelf(nums3);
        System.out.println(Arrays.toString(result3));

        /* Edge Case 2 (array of length 0) - Expected Output: = [] */
        int[] nums4 = {};
        int[] result4 = poaes.productExceptSelf(nums4);
        System.out.println(Arrays.toString(result4));

        /* Edge Case 3 (array of only zeroes) - Expected Output: [0, 0, 0, 0] */
        int[] nums5 = {0, 0, 0, 0};
        int[] result5 = poaes.productExceptSelf(nums5);
        System.out.println(Arrays.toString(result5));

        /* Edge Case 4 (array of only ones) - Expected Output: [1, 1, 1, 1] */
        int[] nums6 = {1, 1, 1, 1};
        int[] result6 = poaes.productExceptSelf(nums6);
        System.out.println(Arrays.toString(result6));

        /* Edge Case 5 (array with one negative) - Expected Output: [-24, -12, -8, 6] */
        int[] nums7 = {1, 2, 3, -4};
        int[] result7 = poaes.productExceptSelf(nums7);
        System.out.println(Arrays.toString(result7));

        /* Edge Case 6 (all negatives) - Expected Result [-24, -12, -8, -6] */
        int[] nums8 = {-1, -2, -3, -4};
        int[] result8 = poaes.productExceptSelf(nums8);
        System.out.println(Arrays.toString(result8));

        /* Edge Case 7 (array with large numbers) - Expected Output: Integer overflow will cause the answer to be wrong (can be fixed by using a long integer instead) */ 
        int[] nums9 = {100000, 200000, 300000, 400000};
        int[] result9 = poaes.productExceptSelf(nums9);
        System.out.println(Arrays.toString(result9));

        /* Edge Case 8 (array with alternating positives and negatives) - Expected Output: [1, -1, 1, -1] */
        int[] nums10 = {1, -1, 1, -1};
        int[] result10 = poaes.productExceptSelf(nums10);
        System.out.println(Arrays.toString(result10));
    }
}
