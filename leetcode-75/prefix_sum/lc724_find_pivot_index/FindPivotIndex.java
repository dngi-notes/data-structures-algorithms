package prefix_sum.lc724_find_pivot_index;

public class FindPivotIndex {
    /*
     * Given an array of integers `nums`
     * calculate the pivot index of this array
     * 
     * the pivot index is the index where the sum of all the numbers, strictly to
     * the left,
     * is equal to the sum of all te number's strictly to the index's right
     * 
     * if the index is on the left edge of the array, then the left sum is 0,
     * because there
     * are no elements to the left
     * This also applies to the right edge of the array
     * 
     * return the leftmost pivot index. if no such index exists, return -1
     */
    public int pivotIndex(int[] nums) {
        /*
         * iterate over every number in nums
         * calculate the sum of the elements strictly left and right
         * do this until we reach nums.length - 1
         * return the index if we reach it
         * else return -1
         */

        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            int rightSum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }

            if (rightSum == leftSum) {
                return i;
            }
        }
        return -1;
    }
}
