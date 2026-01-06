package amazon.easy.lc1_two_sum;

import java.util.*;

public class TwoSum {
    /*
     * Given an array of integers 'nums' and an integer 'target', return indices of the two numbers such that they add up to target
     * 
     * You may assume that each input would only have one solution and you may not use the same element twice.
     * You can return the answer in any order.
     */
    public List<Integer> twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        if(nums == null || nums.length == 0) {
            return result;
        }

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                result.add(map.get(complement));
                result.add(i);
            }

            map.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        String output = "Output: ";

        int[] nums1 = {2, 7, 11, 15};
        System.out.println(output + ts.twoSum(nums1, 9)); // expected [0, 1]

        int[] nums2 = {3, 2, 4};
        System.out.println(output + ts.twoSum(nums2, 6)); // expected [1, 2];

        int[] nums3 = {3, 3};
        System.out.println(output + ts.twoSum(nums3, 6)); // expected [0, 1]

    }
}
