package amazon.medium.lc875_koko_eating_bananas;

import java.util.Arrays;

public class MinEatingSpeed {
    /*
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has
     * piles[i] bananas. The guards have gone and will come back in h hours.
     * 
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
     * chooses some pile of bananas and eats k bananas from that pile. If the pile
     * has less than k bananas, she eats all of them instead and will not eat any
     * more bananas during this hour.
     * 
     * Koko likes to eat slowly but still wants to finish eating all the bananas
     * before the guards return.
     * 
     * Return the minimum integer k such that she can eat all the bananas within h
     * hours.
     * 
     * Input: piles = [3,6,7,11], h = 8
     * Output: 4
     */
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0 || h < piles.length) {
            return 0;
        }

        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int minimumK = right;

        while(left <= right) {
            int k = left + (right = left) / 2;

            int totalTime = 0;
            for(int pile : piles) {
                totalTime += Math.ceil((double) pile / k);
            }

            if(totalTime <= h) {
                minimumK = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return minimumK;
    }
}
