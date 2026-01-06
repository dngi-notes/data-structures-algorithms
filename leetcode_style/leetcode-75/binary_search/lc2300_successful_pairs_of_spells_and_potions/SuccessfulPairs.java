package binary_search.lc2300_successful_pairs_of_spells_and_potions;

import java.util.Arrays;

public class SuccessfulPairs {
    /*
     * You are given two positive integer arrays spells and potions, of length n and
     * m respectively, where spells[i] represents the strength of the ith spell and
     * potions[j] represents the strength of the jth potion.
     * 
     * You are also given an integer success. A spell and potion pair is considered
     * successful if the product of their strengths is at least success.
     * 
     * Return an integer array pairs of length n where pairs[i] is the number of
     * potions that will form a successful pair with the ith spell.
     */
    public int[] successfulPairs(int[] spells, int[] potions, int successful) {
        if(spells == null || potions == null || spells.length == 0 || potions.length == 0) {
            return new int[spells.length];
        }

        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        
        for(int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length - 1;

            while(left <= right) {
                int mid = left + (right - left) / 2;

                if((long) spells[i] * potions[mid] >= successful) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            pairs[i] = potions.length - left;
        }

        return pairs;
    }

    public static void main(String[] args) {
        SuccessfulPairs sp = new SuccessfulPairs();
        String output = "Output: ";

        int[] spells1 = {3, 1, 2};
        int[] potions1 = {8, 5, 8};
        System.out.println(output + Arrays.toString(sp.successfulPairs(spells1, potions1, 16))); // expected [2, 0, 2]
        System.out.println(output + Arrays.toString(sp.successfulPairs(spells1, potions1, 0))); // expected [3, 3, 3]

        int[] spells2 = {};
        int[] potions2 = {1, 2, 3};
        System.out.println(output + Arrays.toString(sp.successfulPairs(spells2, potions2, 2))); // expected []

        int[] spells3 = {2, 2, 4};
        int[] potions3 = null;
        System.out.println(output + Arrays.toString(sp.successfulPairs(spells3, potions3, 4))); // expected [0, 0, 0]
    }
}
