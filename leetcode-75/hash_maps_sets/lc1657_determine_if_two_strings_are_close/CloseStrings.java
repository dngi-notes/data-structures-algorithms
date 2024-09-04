package hash_maps_sets.lc1657_determine_if_two_strings_are_close;

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
         */
        
     }
}