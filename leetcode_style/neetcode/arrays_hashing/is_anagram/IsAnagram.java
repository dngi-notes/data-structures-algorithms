package neetcode.arrays_hashing.is_anagram;

import java.util.*;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        Set<Character> sSet = new HashSet<>();
        Set<Character> tSet = new HashSet<>();

        for (char ch : s.toCharArray()) {
            sSet.add(ch);
        }

        for (char ch : t.toCharArray()) {
            tSet.add(ch);
        }

        return sSet.equals(tSet);
    }

    public static void main(String[] args) {
        IsAnagram ia = new IsAnagram();
        String output = "Output: ";

        System.out.println(output + ia.isAnagram("racecar", "carrace"));
        System.out.println(output + ia.isAnagram("jar", "jam"));
        System.out.println(output + ia.isAnagram("string1", null));
    }
}
