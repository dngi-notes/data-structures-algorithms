package google.easy.lc_268_missing_number;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array
 * 
 * e.g. given nums = [3, 0, 1], the output = 2, because sorted we have [0, 1, 3]
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }

        return xor;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.missingNumber(new int[]{3, 0, 1}));
    }
}
