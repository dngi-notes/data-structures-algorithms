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
         * get the total sum of the array first
         * initialise a variable for the left sum
         * calculate the right sum (total sum - left sum - nums[i])
         * 
         * if the left sum and right sum are equal, return the index `i`
         * else return -1
         */

        if(nums == null || nums.length == 0) {
            return -1;
        }

        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if(rightSum == leftSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex pi = new FindPivotIndex();
        String output = "Output: ";

        /* Example 1 */
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println(output + pi.pivotIndex(nums1)); // expected output: 3

        /* Example 2 */
        int[] nums2 = {1, 2, 3};
        System.out.println(output + pi.pivotIndex(nums2)); // expected output: -1

        int[] nums3 = {2, 1, -1};
        System.out.println(output + pi.pivotIndex(nums3)); // expected output: 0

        /* Edge Case 1 (array of length 1) */
        int[] nums4 = { 1 };
        System.out.println(output + pi.pivotIndex(nums4)); // expected output: 0

        /* Edge Case 2 (Empty array) */
        int[] nums5 = {};
        System.out.println(output + pi.pivotIndex(nums5)); // expected output: -1

        /* Edge Case 3 (null array) */
        int[] nums6 = null;
        System.out.println(output + pi.pivotIndex(nums6)); // expected output: -1
    }
}
