
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

        /* Example 1 - Expected Output: 24, 12, 8, 6 */
        int[] nums = {1, 2, 3, 4};
        int[] result = poaes.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
        
    }
}
