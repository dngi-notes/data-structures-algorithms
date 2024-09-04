package hash_maps_sets.lc1657_determine_if_two_strings_are_close;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class CloseStrings {
    /*
     * Two strings are considered close if you can attain one from the other
     * using the following operations:
     * 
     * - Operation 1: Swap any two existing characters.
     * --> For example, abcde -> aecdb
     * 
     * - Operation 2: Transform every occurrence of one existing character
     * into another existing character, and do the same with the other character
     * --> For example, aacabb -> bbcbaa (all a's turn to b's and all b's to a's)
     */

    public boolean closeStrings(String word1, String word2) {
        /* Strings need to be the same length for the operations to be possible */

        /*
         * create hashmaps to get the frequency of the characters in both strings
         * if they're the same return true
         * 
         * check if the strings have the same set of numbers (keys in the map)
         * if they are equal return true, else return false
         * 
         * Map out the frequency of the frequencies (to support operation 2)
         * if the frequencies are equal, return true, else false
         */
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> word1Freqs = new HashMap<>();
        Map<Character, Integer> word2Freqs = new HashMap<>();

        for (char ch : word1.toCharArray()) {
            word1Freqs.put(ch, word1Freqs.getOrDefault(ch, 0) + 1);
        }

        for (char ch : word2.toCharArray()) {
            word2Freqs.put(ch, word2Freqs.getOrDefault(ch, 0) + 1);
        }

        Set<Character> word1Chars = word1Freqs.keySet();
        Set<Character> word2Chars = word2Freqs.keySet();
        if (!word1Chars.equals(word2Chars)) {
            return false;
        }

        Map<Integer, Integer> word1FreqCount = new HashMap<>();
        Map<Integer, Integer> word2FreqCount = new HashMap<>();

        for(int freq: word1Freqs.values()) {
            word1FreqCount.put(freq, word1FreqCount.getOrDefault(freq, 0) + 1);
        }

        for(int freq: word2Freqs.values()) {
            word2FreqCount.put(freq, word2FreqCount.getOrDefault(freq, 0) + 1);
        }
        
        return word1FreqCount.equals(word2FreqCount);
    }
}
