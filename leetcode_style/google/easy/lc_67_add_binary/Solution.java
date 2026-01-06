package google.easy.lc_67_add_binary;

public class Solution {
    /**
     * Given two binary strings a and b, return their sum as a binary string.
     * 
     * Example 1:
     * 
     * Input: a = "11", b = "1"
     * Output: "100"
     * 
     * Example 2:
     * 
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     * 
     */
    public static String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder res = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >= 0 || carry != 0) {
            int iBit;
            int jBit;
            if (i >= 0) {
                iBit = a.charAt(i) - '0';
            } else {
                iBit = 0;
            }
            
            if (j >= 0) {
                jBit = b.charAt(j) - '0';
            } else {
                jBit = 0;
            }

            if (i < 0) iBit = 0;
            if (j < 0) jBit = 0;

            int sum = iBit + jBit + carry;
            int sumBit = sum % 2;
            carry = sum / 2;

            res.append(sumBit);
            i--;
            j--;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1")); // expected: "100"
        System.out.println(addBinary("1010", "1011")); // expected: "10101"
    }
}
