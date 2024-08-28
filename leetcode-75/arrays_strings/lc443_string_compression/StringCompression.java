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
        int iterator = 0;
        int writer = 0;
    
        while (iterator < chars.length) {
            int count = 0;
            char currentChar = chars[iterator];
    
            while (iterator < chars.length && chars[iterator] == currentChar) {
                count++;
                iterator++;
            }
            chars[writer++] = currentChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[writer++] = c;
                }
            }
        }
        return writer;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();

        /* Example 1: Expected Result: 6, because length of a2b2c3 is 6 */
        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println(sc.compress(chars));

        /* Edge Case 1: Empty array, Expected Result: 0 */
        char[] chars2 = {};
        System.out.println(sc.compress(chars2)); // Expected: 0

        /* Edge Case 2: Single character array, Expected Result: 1 */
        char[] chars3 = { 'a' };
        System.out.println(sc.compress(chars3)); // Expected: 1

        /* Edge Case 3: All unique characters, Expected Result: 6 */
        char[] chars4 = { 'a', 'b', 'c', 'd', 'e', 'f' };
        System.out.println(sc.compress(chars4)); // Expected: 6

        /* Edge Case 4: All same characters, Expected Result: 2, because length of a6 is 2 */
        char[] chars5 = { 'a', 'a', 'a', 'a', 'a', 'a' };
        System.out.println(sc.compress(chars5)); // Expected: 2

        /* Edge Case 5: Mixed characters with varying frequencies, Expected Result: 8, because length of a2b3c1d2 is 8 */
        char[] chars6 = { 'a', 'a', 'b', 'b', 'b', 'c', 'd', 'd' };
        System.out.println(sc.compress(chars6)); // Expected: 8

        /* Edge Case 6: Character with double-digit frequency, Expected Result: 3, because length of a12 is 3 */
        char[] chars7 = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' };
        System.out.println(sc.compress(chars7));
    }
}