package amazon.medium.lc50_pow_x_n;

public class Pow {
    /*
     * Implement pow(x, n), which calculates x raised to the power n (i.e., x ^ n).
     */
        public double myPow(double x, int n) {
            if(n == 0) {
                return 1;
            }

            long N = n;
            if(N < 0) {
                x = 1 / x;
                N = -N;
            }

            return powHelper(x, N);
        }

        private double powHelper(double x, long n) {
            if(n == 0) {
                return 1;
            }

            double half = powHelper(x * x, n / 2);
            return (n % 2 == 0) ? half : x * half;
        }

    public static void main(String[] args) {
        Pow power = new Pow();
        String output = "Output: ";

        System.out.println(output + power.myPow(2.00000, 10)); // expected 1024.00000
        System.out.println(output + power.myPow(2.10000, 3)); // expected 9.26100
        System.out.println(output + power.myPow(2.00000, -2)); // expected 0.25
        System.out.println(output + power.myPow(0.00001, Integer.MAX_VALUE));
    }
}
