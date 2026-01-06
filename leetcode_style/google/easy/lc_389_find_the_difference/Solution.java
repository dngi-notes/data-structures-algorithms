package google.easy.lc_389_find_the_difference;

public class Solution {
    public static char findTheDifference(String s, String t) {
        char result = 0;

        for (char ch : s.toCharArray()) {
            result ^= ch;
        }

        for (char ch : t.toCharArray()) {
            result ^= ch;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));     
        System.out.println(findTheDifference("ab", "b"));
        System.out.println(findTheDifference("", ""));
    }
}
