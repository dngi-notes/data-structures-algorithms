package google.lc_349_intersection_of_two_arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays `nums1` and `nums2`, return an array
 * of their intersection. Each element in the result must be unique
 * and you may return the result in any order
 * 
 * e.g.
 * input: nums1 = [1, 2, 2, 1], nums2 = [2, 2]
 * output: [2]
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
