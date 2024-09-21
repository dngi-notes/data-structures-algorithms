package binary_search.lc875_koko_eating_bananas;

import java.util.Arrays;

public class EatingBananas {
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
     */
    public int minEatingSpeed(int[] piles, int h) {
        /*
         * no need to sort the array 
         * use a local minimum (1) and maximum (the max of the pile) as left and right
         * find k (using mid point calculation)
         *  keep track of the time
         * handle left and right window change based on time compared to h?
         */
        int left = 1;
        int right = Arrays.stream(piles)
                    .max().getAsInt();
        int minimumK = right;

        while(left <= right) {
            int k = left + (right - left) / 2;

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

    main
}
