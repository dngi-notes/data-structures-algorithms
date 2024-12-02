package neetcode.binary_search.koko_eating_bananas;

import java.util.Arrays;

public class EatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        if(piles == null || piles.length == 0) {
            return 0;
        }

        int left = 1;
        int right = Arrays.stream(piles)
                    .max()
                    .getAsInt();
        int minimumK = right;

        while(left <= right) {
            int k = left + (right - left) / 2;

            int totalTime = 0;
        }
    }
}
