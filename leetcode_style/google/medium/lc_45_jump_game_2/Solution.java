package google.medium.lc_45_jump_game_2;

import java.util.Arrays;

public class Solution {
    private static final int INF = Integer.MAX_VALUE / 2;

    public static int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        if (nums.length == 2) return 1;
        
        int n = nums.length;
        int[] cache = new int[n];
        Arrays.fill(cache, INF);

        cache[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int steps = nums[i];
            for (int j = 1; j <= steps && i + j < n; j++) {
                cache[i] = Math.min(cache[i], 1 + cache[i + j]);
            }
        }

        return cache[0];
    }
    
    // memoization solution
    // public static int jump(int[] nums) {
    //     int[] cache = new int[nums.length + 1];
    //     Arrays.fill(cache, -1);

    //     return jumpHelper(nums, 0, cache);
    // }

    // private static int jumpHelper(int[] nums, int i, int[] cache) {
    //     if (i >= nums.length - 1) {
    //         return 0;
    //     }

    //     if (nums[i] == 0) {
    //         return INF;            
    //     }

    //     if (cache[i] != -1) {
    //         return cache[i];
    //     }

    //     int minJumps = INF;
    //     for (int step = 1; step <= nums[i]; step++) {
    //         int result = jumpHelper(nums, i + step, cache);

    //         if (result != INF) {
    //             minJumps = Math.min(minJumps, 1 + result);
    //         }
    //     }
        
    //     cache[i] = minJumps;
    //     return cache[i];
    // }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4})); // expected: 2
        System.out.println(jump(new int[]{2, 3, 0, 1, 4})); // expected: 2
        System.out.println(jump(new int[]{2, 2, 1, 1, 4})); // expected: 3
    }
}
