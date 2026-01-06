package amazon.easy.lc191_number_of_1_bits;

public class HammingWeight {
    /*
     * Given a positive integer n, write a function that returns the number of
     * set bits
     * in its binary representation (also known as the Hamming weight).
     */
    public int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);

        int oneBitCount = 0;
        for(char bit : binaryString.toCharArray()) {
            if(bit == '1') {
                oneBitCount++;
            }
        }

        return oneBitCount;
    }

    public static void main(String[] args) {
        HammingWeight hw = new HammingWeight();
        String output = "Output: ";

        System.out.println(output + hw.hammingWeight(11)); // expected 3
        System.out.println(output + hw.hammingWeight(128)); //  expected 1
        System.out.println(output + hw.hammingWeight(2147483645)); // expected 30
    }
}
