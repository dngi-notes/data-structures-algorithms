package google.easy.lc_1768_merge_strings_alternatively;

public class Solution {
    public static String mergeAlternately(String word1, String word2) {
        if (word1 == null || word1.isEmpty()) return word2;
        if (word2 == null || word2.isEmpty()) return word1;

        StringBuilder merger = new StringBuilder();
        int p1 = 0;
        int p2 = 0;

        while (p1 < word1.length() || p2 < word2.length()) {
            if (p1 < word1.length()) {
                merger.append(word1.charAt(p1));
                p1++;
            }

            if (p2 < word2.length()) {
                merger.append(word2.charAt(p2));
                p2++;
            }
        }

        return merger.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "xyz")); // expected: axbycz
    }
}
