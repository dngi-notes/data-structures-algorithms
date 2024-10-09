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
        memo[n] = 1;

        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                memo[i] = 0;
            } else {
                memo[i] = memo[i + 1];
                if(s.charAt(i) == '1' || (s.charAt(i + 1) <= 6)) {
                    memo[i] = memo[i + 2];
                }
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        String output = "Output: ";

    }
}
