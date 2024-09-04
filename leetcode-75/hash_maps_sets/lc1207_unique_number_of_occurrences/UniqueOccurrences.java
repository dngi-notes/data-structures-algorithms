package hash_maps_sets.lc1207_unique_number_of_occurrences;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class UniqueOccurrences {
    /*
     * Given an array of integers `arr`
     * return true if the number of occurences of each value in the array is unique
     * or false otherwise
     */
    public boolean uniqueOccurrences(int[] arr) {
        /*
         * create a hashmap to get the occurrence of each value in the array
         * create a set to check for freqs of values we've seen
         * if we've seen the freq already, return false
         * else return true
         */
        if(arr == null) {
            return false;
        }

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int val : arr) {
            freqs.put(val, freqs.getOrDefault(val, 0) + 1);
        }

        Set<Integer> seenFreqs = new HashSet<>();

        for (int val : freqs.values()) {
            if (seenFreqs.contains(val)) {
                return false;
            }
            seenFreqs.add(val);
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueOccurrences uo = new UniqueOccurrences();
        String output = "Output: ";

        /* Example 1 - Expected Output: true */
        int[] arr1 = { 1, 2, 2, 1, 1, 3 };
        System.out.println(output + uo.uniqueOccurrences(arr1));

        /* Example 2 - Expected Output: false */
        int[] arr2 = { 1, 2, 3 };
        System.out.println(output + uo.uniqueOccurrences(arr2));

        /* Example 3 - Expected Output: true */
        int[] arr3 = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        System.out.println(output + uo.uniqueOccurrences(arr3));

        /* Edge Case 1 (null array) - Expected Output: false */
        int[] arr4 = null;
        System.out.println(output + uo.uniqueOccurrences(arr4));
    }
}