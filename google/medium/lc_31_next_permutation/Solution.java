package google.medium.lc_31_next_permutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 2;
        while (i >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] > nums[j]) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int start) {
        int left = start;
        int right = arr.length - 1;

        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(nums));
        s.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
