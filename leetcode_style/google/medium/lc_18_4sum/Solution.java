package google.medium.lc_18_4sum;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
/**
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * You may return the answer in any order.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a - 1] == nums[a]) continue;

            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b - 1] == nums[b]) continue;

                int left = b + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long quadrupletSum = (long) nums[a] + nums[b] + nums[left] + nums[right];

                    if (quadrupletSum < target) {
                        left++;
                    } else if (quadrupletSum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left - 1] == nums[left]) {
                            left++;
                        }

                        while (left < right && nums[right + 1] == nums[right]) {
                            right--;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(sol.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }
}
