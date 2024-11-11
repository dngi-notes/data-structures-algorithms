package neetcode.dynamic_programming.lc198_house_robber;

public class HouseRobber {
    /*
     * You are a professional robber planning to rob houses along a street. Each
     * house has a certain amount of money stashed, the only constraint stopping you
     * from robbing each of them is that adjacent houses have security systems
     * connected and it will automatically contact the police if two adjacent houses
     * were broken into on the same night.
     * 
     * Given an integer array nums representing the amount of money of each house,
     * return the maximum amount of money you can rob tonight without alerting the
     * police.
     */
    public int rob(int[] nums) {
        int n = nums.length;

        /*
         * Edge Cases:
         * 1. If there are no houses
         * 2. If there's only one house
         */
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] dp = new int[n];
        /*
         * Solving Sub-Problems (Base Cases):
         * 1. The last house itself alone can be robbed (nums[n-1])
         * 2. The second last house (nums[n-2]) can be robbed or the last house (nums[n-1]) (only if n is of size 2 or more)
         */
        dp[n - 1] = nums[n - 1];
        if(n >= 2) {
            dp[n - 2] = Math.max(nums[n - 1], nums[n - 2]);
        }

        /*
         * Fill in the dp (memo array)
         * starting at the third last, working down to the first
         */
        for(int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

    // adding recursive solution:
    public int robRecursive(int[] nums) {
        return robRecursiveHelper(nums, nums.length - 1);
    }

    public int robRecursiveHelper(int[] nums, int index) {
        if(index < 0) {
            return 0;
        }

        if(index == 0) {
            return nums[0];
        }

        return Math.max(nums[index] + robRecursiveHelper(nums, index - 2), robRecursiveHelper(nums, index - 1));
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        String output = "Output: ";

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(output + hr.rob(nums1));

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(output + hr.rob(nums2));
    }
}
