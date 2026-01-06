package amazon.easy.lc268_missing_number;

import java.util.Arrays;

public class MissingNumber {
    /*
     * Given an array nunms containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;

            if(nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        String output = "Output: ";

        int[] nums1 = {0, 1, 2, 4, 5, 6, 7};
        System.out.println(output + mn.missingNumber(nums1));
    }
}