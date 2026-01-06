package stacks.lc394_decode_string;

import java.util.Stack;

public class DecodeString {
    /*
     * Given an encoded string, return its decoded string.
     * 
     * The encoding rule is: k[encoded_string], where the encoded_string inside the
     * square brackets is being repeated exactly k times. Note that k is guaranteed
     * to be a positive integer.
     * 
     * You may assume that the input string is always valid; there are no extra
     * white spaces, square brackets are well-formed, etc. Furthermore, you may
     * assume that the original data does not contain any digits and that digits are
     * only for those repeat numbers, k. For example, there will not be input like
     * 3a or 2[4].
     * 
     * The test cases are generated so that the length of the output will never
     * exceed 105.
     */
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int k = 0;
        String currentString = "";
        
        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } 
            else if(ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);

                k = 0;
                currentString = "";
            } 
            else if(ch == ']') {
                int repeated = countStack.pop();
                StringBuilder decodedString = new StringBuilder(stringStack.pop());

                for(int i = 0; i < repeated; i++) {
                    decodedString.append(currentString);
                }

                currentString = decodedString.toString();
            } else {
                currentString += ch;
            }
        }
        
        return currentString;
    }

    /*
     * time complexity: O(n)
     * space complexity: O(n)
     */

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String output = "Output: ";

        /* LeetCode Examples */
        String s1 = "3[a]2[bc]";
        System.out.println(output + ds.decodeString(s1)); //expected output: aaabcbc

        String s2 = "3[a2[c]]";
        System.out.println(output + ds.decodeString(s2)); //expected output: accaccacc

        String s3 = "2[abc]3[cd]ef";
        System.out.println(output + ds.decodeString(s3)); //expected output: abcabccdcdcdef

        /*EDGE CASES */
        String s4 = "";
        System.out.println(output + ds.decodeString(s4)); //expected output: ""

        String s5 = "2[]";
        System.out.println(output + ds.decodeString(s5)); //expected output: ""

        String s6 = "100[a]";
        System.out.println(output + ds.decodeString(s6));

        String s7 = "a";
        System.out.println(output + ds.decodeString(s7));
    }
}