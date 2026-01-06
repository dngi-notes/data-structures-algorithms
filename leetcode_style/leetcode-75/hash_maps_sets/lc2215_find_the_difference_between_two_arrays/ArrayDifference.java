package hash_maps_sets.lc2215_find_the_difference_between_two_arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayDifference {
    /*
     * Given two 0-indexed integer arrays nums1 and nums2,
     * return a list `answer` of size 2 where:
     * 
     * ---> answer[0] is a list of all distinct integers in nums[1] which are not in
     * nums2
     * ---> answer[1] is a list of all distinct integers in nums[2] which are not in
     * nums1
     * 
     * NOTE: the integers can be return in any order
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();

        for (int num : nums1) {
            nums1Set.add(num);
        }

        for (int num : nums2) {
            nums2Set.add(num);
        }

        Set<Integer> list1Set = new HashSet<>();
        Set<Integer> list2Set = new HashSet<>();

        for(int num : nums1) {
            if(!nums2Set.contains(num)) {
                list1Set.add(num);
            }
        }

        for(int num: nums2) {
            if(!nums1Set.contains(num)) {
                list2Set.add(num);
            }
        }
        
        answer.add(new ArrayList<>(list1Set));
        answer.add(new ArrayList<>(list2Set));

        return answer;
    }

    /*
     * Time Complexity O(m + n) -> where m is the length of nums1 and n is the length of nums2
     * Space Complexity O(m + n)
     */

    public static void main(String[] args) {
        ArrayDifference ad = new ArrayDifference();
        String output = "Output: ";

        /* Example 1 */
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 2, 4, 6 };
        System.out.println(output + ad.findDifference(nums1, nums2)); // expected output: [1, 3], [4, 6]

        int[] nums3 = { 1, 2, 3, 3 };
        int[] nums4 = { 1, 1, 2, 2};
        System.out.println(output + ad.findDifference(nums3, nums4)); // expected output: [3], []

        /* Edge Case 1 (same elements) */
        int[] nums5 = { 1, 2, 3 };
        int[] nums6 = { 1, 2, 3 };
        System.out.println(output + ad.findDifference(nums5, nums6)); // expected output: [], []

        /* Edge Case 2: (both empty) */
        int[] nums7 = {};
        int[] nums8 = {};
        System.out.println(output + ad.findDifference(nums7, nums8)); // expected output: [], []

        /* Edge Case 3: (one empty) */
        int[] nums9 = {1, 2, 3};
        int[] nums10 = {};
        System.out.println(output + ad.findDifference(nums9, nums10)); // expected output: [1, 2, 3], []

        /* Edge Case 4: (completely distinct elements) */
        int[] nums11 = {1, 2, 3};
        int[] nums12 = {4, 5, 6};
        System.out.println(output + ad.findDifference(nums11, nums12)); // expected output: [1, 2, 3], [4, 5, 6]
    }
}
