package arrays_strings;
/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. 
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 * 
 */
class MergeStringAlternatively {
    public String mergeAlternatively(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int len1 = word1.length();
        int len2 = word2.length();

        int i = 0;
        int j = 0;

        while(i < len1 || j < len2) {
            if(i < len1) {
                sb.append(word1.charAt(i));
                i++;
            }

            if(j < len2) {
                sb.append(word2.charAt(j));
                j++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MergeStringAlternatively msa = new MergeStringAlternatively();

        String word1 = "abc";
        String word2 = "pqr";

        System.out.println(msa.mergeAlternatively(word1, word2));
    }
}

/**
 * Time Complexity: O(n + m), where n and m are the lengths of word1 and word2 respectively
 */