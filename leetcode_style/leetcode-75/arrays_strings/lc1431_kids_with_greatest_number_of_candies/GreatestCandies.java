/*
Here are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.
*/

package arrays_strings.lc1431_kids_with_greatest_number_of_candies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        /**
         * For every child in the array candies
         * if we add extraCandies to candies[i], add true to the boolean list res, if it
         * will become the greatest (is greater than or equal to the current max) in the array
         * else return false
         * return res
         */
        List<Boolean> result = new ArrayList<>();

        if(candies.length == 0) {
            return result;
        }

        int maxCandies = Arrays.stream(candies).max().getAsInt();
        for (int i = 0; i < candies.length; i++) {
            int currentCandies = candies[i];

            result.add(currentCandies + extraCandies >= maxCandies);
        }
        return result;
    }

    public static void main(String[] args) {
        GreatestCandies gc = new GreatestCandies();

        
        int[] candies1 = {2, 3, 5, 1, 3};
        int extraCandies1 = 3;
        System.out.println(gc.kidsWithCandies(candies1, extraCandies1)); // [true, true, true, false, true]

        // Edge case: Empty array
        int[] candies2 = {};
        int extraCandies2 = 3;
        System.out.println(gc.kidsWithCandies(candies2, extraCandies2)); // []

        // Edge case: One element
        int[] candies3 = {5};
        int extraCandies3 = 3;
        System.out.println(gc.kidsWithCandies(candies3, extraCandies3)); // [true]

        // Edge case: All elements are the same
        int[] candies4 = {2, 2, 2, 2, 2};
        int extraCandies4 = 3;
        System.out.println(gc.kidsWithCandies(candies4, extraCandies4)); // [true, true, true, true, true]

        // Edge case: Large numbers
        int[] candies5 = {1000, 2000, 3000, 4000, 5000};
        int extraCandies5 = 1000;
        System.out.println(gc.kidsWithCandies(candies5, extraCandies5)); // [false, false, true, true, true]

        // Edge case: Negative numbers (if applicable)
        int[] candies6 = {-1, -2, -3, -4, -5};
        int extraCandies6 = 3;
        System.out.println(gc.kidsWithCandies(candies6, extraCandies6)); // [true, true, true, true, true]
    }
}

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */