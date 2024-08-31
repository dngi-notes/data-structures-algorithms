package sliding_window.lc1456_max_number_of_vowels_in_a_substring_given_length;

public class MaxNumberOfVowels {
    /*
     * Given a string s and an integer k
     * return the maximum number of vowel letters in any substring of s with length
     * k
     * 
     * vowel letters in Englis are 'a', 'e', 'i', 'o', 'u'.
     */

    public int maxVowels(String s, int k) {
        /*
         * returning the max number of vowels, so we need to keep track of the vowels:
         * e.g. vowels = 0
         * iterate over a window of size k, and for every element inside the window that
         * is a vowel we update maxVowels
         * finally return maxVowels
         */
        if(s.length() == 0) {
            return 0;
        }

        int vowels = 0;
        for(int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))) {
                vowels++;
            }
        }

        int maxVowels = vowels;
        for(int r = k; r < s.length(); r++) {
            if(isVowel(s.charAt(r))) {
                vowels++;
            }

            if(isVowel(s.charAt(r - k))) {
                vowels--;
            }
            maxVowels = Math.max(maxVowels, vowels);
        }
        return maxVowels;
    }

    // method to check if a character in the string is a vowel
    private boolean isVowel(char c) {
        return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U');
    }

    public static void main(String[] args) {
        MaxNumberOfVowels mnov = new MaxNumberOfVowels();

        /*Example 1 -  Expected Output: 3 */
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.println(mnov.maxVowels(s1, k1));

        /* Example 2 - Expected Output: 2 */
        String s2 = "aeiou";
        int k2 = 2;
        System.out.println(mnov.maxVowels(s2, k2));

        /* Example 3 - Expected Output: 2 */
        String s3 = "leetcode";
        int k3 = 3;
        System.out.println(mnov.maxVowels(s3, k3));

        /* Edge Case 1 - Expected Output: 0 */
        String s4 = "";
        int k4 = 1;
        System.out.println(mnov.maxVowels(s4, k4));
    }
}
