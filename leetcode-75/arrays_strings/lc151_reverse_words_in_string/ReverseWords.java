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

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();

        String s = "the sky is blue";
        System.out.println(reverseWords.reverseWords(s));

        String s2 = "a good   example";
        System.out.println(reverseWords.reverseWords(s2));

        String s3 = "";
        System.out.println(reverseWords.reverseWords(s3));

        String s4 = null;
        System.out.println(reverseWords.reverseWords(s4));

        String s5 = "word";
        System.out.println(reverseWords.reverseWords(s5));
    }
}
