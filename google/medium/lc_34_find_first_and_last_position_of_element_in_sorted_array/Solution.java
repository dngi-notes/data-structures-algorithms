package google.medium.lc_34_find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

/*
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int start = lowerBound(nums, target);
        int end = lowerBound(nums, target + 1) - 1;

        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{start, end};
    }

    private static int lowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8))); // expected: [3, 4]
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6))); // expected: [-1, -1]
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0))); // expected: [-1, -1]
    }
}
