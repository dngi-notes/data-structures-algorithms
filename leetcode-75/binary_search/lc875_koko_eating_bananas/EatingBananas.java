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
        if(h < piles.length) {
            return 0;
        }

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

    public static void main(String[] args) {
        EatingBananas eb = new EatingBananas();
        String output = "Output: ";

        int[] piles1 = {3, 6, 7, 11};
        System.out.println(output + eb.minEatingSpeed(piles1, 8)); // expected result: 4

        int[] piles2 = {30, 11, 23, 4, 20};
        System.out.println(output + eb.minEatingSpeed(piles2, 5)); // expected result: 30

        int[] piles3 = {30, 11, 23, 4, 20};
        System.out.println(output + eb.minEatingSpeed(piles3, 6)); // expected result: 23

        int[] piles4 = {3, 6, 7, 11};
        System.out.println(output + eb.minEatingSpeed(piles4, 1)); // expected result: 0
    }
}
