package amazon.easy.lc66_plus_one;

import java.util.Arrays;

public class PlusOne {
    /*
     * You are given a large integer represented as an integer array digits, where
     * each digits[i] is the ith digit of the integer. The digits are ordered from
     * most significant to least significant in left-to-right order. The large
     * integer does not contain any leading 0's.
     * 
     * Increment the large integer by one and return the resulting array of digits.
     */
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        String output = "Output";

        int[] digits1 = {1, 2, 3};
        System.out.println(output + Arrays.toString(po.plusOne(digits1)));
        }
}
