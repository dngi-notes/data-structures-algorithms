package arrays_strings.lc151_reverse_words_in_string;

public class ReverseWords {
    /*
     * Given an input string s, reverse the order of the words.
     * A word is defined as a sequence of non-space characters. The words in s will
     * be separated by at least one space.
     * Return a string of the words in reverse order concatenated by a single space.
     * Note that s may contain leading or trailing spaces or multiple spaces between
     * two words. The returned string should only have a single space separating the
     * words. Do not include any extra spaces.
     */
    public String reverseWords(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        } 

        String[] words = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString() + words[0];
    }

    /** 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();

        /* Example 1 - Expected Output: blue is sky the */
        String s = "the sky is blue";
        System.out.println(reverseWords.reverseWords(s));

        /* Example 2 - Expected Output: example good a */
        String s2 = "a good   example";
        System.out.println(reverseWords.reverseWords(s2));

        /* Edge Case 1 (empty string) - Expected output: "" */
        String s3 = "";
        System.out.println(reverseWords.reverseWords(s3));

        /* Edge Case 2 (null string) - Expected output: null */
        String s4 = null;
        System.out.println(reverseWords.reverseWords(s4));

        /* Edge Case 3 (single word) - Expected output: word */
        String s5 = "word";
        System.out.println(reverseWords.reverseWords(s5));

        /* Edge Case 4 (leading and trailing spaces) - Expected Output: world hello */
        String s6 = "  world hello  ";
        System.out.println(reverseWords.reverseWords(s6));
    }
}
