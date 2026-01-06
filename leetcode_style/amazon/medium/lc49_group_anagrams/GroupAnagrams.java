package amazon.medium.lc49_group_anagrams;

import java.util.*;

public class GroupAnagrams {

    /*
     * Given an array string strs, group the anagrams together,
     * You can return the answer in any order.
     * 
     * Example 1:
     * 
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * 
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 
     * Explanation:
     * 
     * There is no string in strs that can be rearranged to form "bat".
     * The strings "nat" and "tan" are anagrams as they can be rearranged to form
     * each other.
     * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to
     * form each other.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for(String str : strs) {
            int[] count = new int[26];
            for(char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            String key = Arrays.toString(count);
            if(!groupedAnagrams.containsKey(key)) {
                groupedAnagrams.put(key, new ArrayList<>());
            }

            groupedAnagrams.get(key).add(str);
        }

        return new ArrayList<>(groupedAnagrams.values());
    }
}
