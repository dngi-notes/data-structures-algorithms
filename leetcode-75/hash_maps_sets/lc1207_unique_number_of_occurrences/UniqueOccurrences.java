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

        int[] arr1 = { 1, 2, 2, 1, 1, 3 };
        System.out.println(output + uo.uniqueOccurrences(arr1));
    }
}