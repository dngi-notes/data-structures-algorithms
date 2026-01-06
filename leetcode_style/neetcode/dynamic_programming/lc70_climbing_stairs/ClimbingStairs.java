package neetcode.dynamic_programming.lc70_climbing_stairs;

public class ClimbingStairs {
    /*
     * You are climbing a staircase. It takes n steps to reach the top.
     * 
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can
     * you climb to the top?
     */

    // intuition: fibonacci sequence
    public int climbStairs(int n) {
        if(n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        String output = "Output: ";

        System.out.println(output + cs.climbStairs(2)); // expected output: 2    
        System.out.println(output + cs.climbStairs(3)); // expected output: 3
        System.out.println(output + cs.climbStairs(4)); // expected output: 5
        System.out.println(output + cs.climbStairs(5)); // expected output: 5
        
        //edge cases
        System.out.println(output + cs.climbStairs(1)); // expected output: 1
        System.out.println(output + cs.climbStairs(0)); // expected output: 1

    }
}
