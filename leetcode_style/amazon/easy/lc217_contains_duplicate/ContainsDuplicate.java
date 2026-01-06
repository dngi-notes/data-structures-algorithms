package amazon.easy.lc217_contains_duplicate;

import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {
    /*
     * Given an integer array nums, return true if any value appears at least twice
     * in the array, and return false if every element is distinct.
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        for(int num : nums) {
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
        
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(output + cd.containsDuplicate(nums1)); // expected true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(output + cd.containsDuplicate(nums2)); // expected false

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(output + cd.containsDuplicate(nums3)); // expected false
    }
}