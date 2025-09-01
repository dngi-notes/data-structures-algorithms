package google.medium.lc_15_3sum;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > 0) break; 

            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int tripletSum = nums[i] + nums[left] + nums[right];

                if (tripletSum < 0) {
                    left++;
                } else if (tripletSum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
