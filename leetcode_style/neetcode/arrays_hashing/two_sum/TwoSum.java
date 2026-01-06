package neetcode.arrays_hashing.two_sum;

import java.util.*;

public class TwoSum {
    public List<Integer> twoSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result.add(map.get(complement));
                result.add(i);
                break;
            }

            map.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        String output = "Output: ";

        int[] nums1 = { 3, 4, 5, 6 };
        System.out.println(output + ts.twoSum(nums1, 7));

        int[] nums2 = { 4, 5, 6 };
        System.out.println(output + ts.twoSum(nums2, 10));

        int[] nums3 = { 5, 5 };
        System.out.println(output + ts.twoSum(nums3, 10));

        int[] nums4 = null;
        System.out.println(output + ts.twoSum(nums4, 4));

        int[] nums5 = {1, 2, 4};
        System.out.println(output + ts.twoSum(nums5, 20));

        int[] nums6 = {};
        System.out.println(output + ts.twoSum(nums6, 1));
    }
}
