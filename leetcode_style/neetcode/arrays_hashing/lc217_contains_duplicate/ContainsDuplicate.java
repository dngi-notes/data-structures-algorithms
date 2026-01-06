package neetcode.arrays_hashing.lc217_contains_duplicate;

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for(int num: nums) {
            if(seen.contains(num)) {
                return true;
            }

            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        String output = "Output: ";

        int[] nums1 = {1, 2, 3, 3};
        System.out.println(output + cd.containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(output + cd.containsDuplicate(nums2));

    }
}
