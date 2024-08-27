package arrays_strings.lc305_reverse_vowels_in_string;

import java.util.Arrays;

/** Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', 
 * and they can appear in both lower and upper cases, more than once. */
public class ReverseVowels {
    /**
     * loop over the input Strings (while loop)
     * with pointers l and r
     * if we have a vowel at left, and a vowel at right swap them
     * keep going until left > right
     */
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while(left < right) {
            char leftChar = chars[left];
            char rightChar = chars[right];

            if(!isVowel(leftChar) || !isVowel(rightChar)) {
                if(!isVowel(leftChar)) {
                    left++;
                }
                if(!isVowel(rightChar)) {
                    right++;
                }
                continue;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }


     /** 
      * isVowel helper method
      */
      private boolean isVowel(char c) {
        return Character.toString(c).matches("[aeiouAEIOU]");
      }

      public static void main(String[] args) {
        ReverseVowels rv = new ReverseVowels();

        String s1 = "hello";
        System.out.println(rv.reverseVowels(s1)); 
      }
}
