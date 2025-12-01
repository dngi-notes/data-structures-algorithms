package google.easy.lc_28_find_index_of_first_occurrence_in_string;

public class Solution {
    /**
     * given 2 strings:
     * @param String needle
     * @param String haystack
     * 
     * return the index of the first occurrence of needle in haystack
     * or -1 if needle is not a part of haystack
     * 
     * example: 
     * in: haystack = "sadbutsad", needle = "sad"
     * output: 0
     */
    public static int findFirst(String haystack, String needle) {
        if (haystack == null || haystack.isEmpty()) return -1;

        int haystackSize = haystack.length();
        for (int i = 0; i < haystackSize; i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findFirst("sadbutsad", "sad")); // expected = 0
        System.out.println(findFirst("leetcode", "leeto")); // expected = -1
        System.out.println(findFirst("youwillfinditeventually", "eventually")); // expected: 13
    }
}
