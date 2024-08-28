package arrays_strings.lc443_string_compression;

public class StringCompression {
    /*
     * Given an array of characters chars, compress it using the following
     * algorithm:
     * 
     * Begin with an empty string s. For each group of consecutive repeating
     * characters in chars:
     * 
     * If the group's length is 1, append the character to s.
     * Otherwise, append the character followed by the group's length.
     * The compressed string s should not be returned separately, but instead, be
     * stored in the input character array chars. Note that group lengths that are
     * 10 or longer will be split into multiple characters in chars.
     * 
     * After you are done modifying the input array, return the new length of the
     * array.
     * 
     * You must write an algorithm that uses only constant extra space.
     */

    public int compress(char[] chars) {
        /**
         * have a pointer l to stay at the start 
         * and a pointer r that will go over the rest of the characters to get the count
         * if the character at r is the same as l, increase the count
         * else add the character and it's count to a String
         * return the length of the string at the end
         */

         int iterator = 0;
         int writer = 0;

         while(iterator < chars.length) {
            int count = 0;
            char currentChar = chars[iterator];

            while(iterator < chars.length && chars[iterator] == currentChar) {
                count++;
                iterator++;
            }
            chars[writer++] = currentChar;
            if(count > 1) {
                for(char c: Integer.toString(count).toCharArray()) {
                    chars[writer++] = c;
                }
            }
            iterator = writer + 1;
         }
         return writer;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();

        /* Example 1: Expected Result: 6, because length of a2b2c3 is 6 */
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(sc.compress(chars));
    }
}