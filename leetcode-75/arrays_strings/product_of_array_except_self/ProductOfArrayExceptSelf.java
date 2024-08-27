
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
    }
}
