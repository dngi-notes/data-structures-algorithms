package amazon.medium.lc15_3sum;

import java.util.*;

public class ThreeSum {
    /*
     * Given an integer array nums, return all the triplets [nums[i], nums[j],
     * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
     * nums[k] == 0.
     * 
     * Notice that the solution set must not contain duplicate triplets.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[0] > 0) {
                break;
            }

            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum < 0) {
                    left++;
                }
                else if(sum > 0) {
                    right--;
                }
                else {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    if(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return triplets;
    }
}
