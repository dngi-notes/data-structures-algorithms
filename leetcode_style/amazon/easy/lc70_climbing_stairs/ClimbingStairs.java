package amazon.easy.lc70_climbing_stairs;

public class ClimbingStairs {
    /*
     * You are climbing a staircase. It takes n steps to reach the top.
     * 
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top
     */
    public int climbStairsRecursive(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    public int climbStairsTabulation(int n) {
        if(n == 0 || n == 1) {
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

    public int climbStairsOptimized(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        
        for(int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }

        return curr;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        String output = "Output: ";

        // recursive tests
        System.out.println(output + cs.climbStairsRecursive(2));
        System.out.println(output + cs.climbStairsRecursive(3));
        System.out.println(output + cs.climbStairsRecursive(4));
        
        System.out.println();
        // tabulation tests
        System.out.println(output + cs.climbStairsTabulation(2));
        System.out.println(output + cs.climbStairsTabulation(3));
        System.out.println(output + cs.climbStairsTabulation(4));

        System.out.println();
        System.out.println(output + cs.climbStairsOptimized(2));
        System.out.println(output + cs.climbStairsOptimized(3));
        System.out.println(output + cs.climbStairsOptimized(4));
    }
}

