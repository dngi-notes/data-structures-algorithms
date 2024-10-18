package neetcode.arrays_hashing.group_anagrams;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            int[] count = new int[26];
            for(char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            String key = Arrays.toString(count);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String output = "Output: ";

        String[] strs1 = {"act", "pots", "tops", "cat", "stop", "hat"};
        System.out.println(output + ga.groupAnagrams(strs1));
    }
}
