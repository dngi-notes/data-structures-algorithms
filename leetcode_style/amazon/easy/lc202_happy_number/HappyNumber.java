package amazon.easy.lc202_happy_number;

public class HappyNumber {
    /*
     * Write an algorithm to determine if a number n is happy.
     * 
     * A happy number is a number defined by the following process:
     * 
     * Starting with any positive integer, replace the number by the sum of the
     * squares of its digits.
     * Repeat the process until the number equals 1 (where it will stay), or it
     * loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy.
     * Return true if n is a happy number, and false if not.
     */

    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);

        while(slow != fast) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }

        return slow == 1;
    }

    private int sumOfSquares(int n) {
        int ans = 0;

        while(n > 0) {
            int remainder = n % 10;
            ans += remainder * remainder;
            n /= 10;
        }

        return ans;
    }
    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        String output = "Output: ";

        System.out.println(output + hn.isHappy(19)); // expected: true
        System.out.println(output + hn.isHappy(2)); // expected: false
    }
}

