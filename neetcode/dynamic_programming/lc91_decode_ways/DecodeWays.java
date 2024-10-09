package neetcode.dynamic_programming.lc91_decode_ways;

public class DecodeWays {
    /*
     * You have intercepted a secret message encoded as a string of numbers. The
     * message is decoded via the following mapping:
     * 
     * "1" -> 'A'
     * 
     * "2" -> 'B'
     * 
     * ...
     * 
     * "25" -> 'Y'
     * 
     * "26" -> 'Z'
     */
    public int numDecodings(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }

        int n = s.length();
        int[] memo = new int[n + 1];
        memo[n] = 1; // substring n is empty (we have finished decoding all characters) and there is one valid encoding (doing nothing)

        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                memo[i] = 0; // if the current character is 0 it cant be decoded so 
            } else {
                // considering decoding the current character as a single letter
                memo[i] = memo[i + 1];
                // checking if the next two characters form a valid number from 10 to 26
                if(i + 1 < n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                    memo[i] += memo[i + 2];
                }
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        String output = "Output: ";

        System.out.println(output + dw.numDecodings("12"));
    }
}
