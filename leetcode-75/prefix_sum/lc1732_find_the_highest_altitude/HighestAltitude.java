package prefix_sum.lc1732_find_the_highest_altitude;

public class HighestAltitude {

    /*
     * There is a biker going on a road trip. The road trip consists of n + 1 points
     * at different altitudes.
     * The biker starts his trip on point 0 with altitude equal 0.
     * 
     * You are given an integer array gain of length n where gain[i] is the net gain
     * in altitude between points i and i + 1 for all (0 <= i < n).
     * Return the highest altitude of a point.
     */

    public int largestAltitude(int[] gain) {
        int highest = 0;
        int currentAltitude = 0;

        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];
            highest = Math.max(highest, currentAltitude);
        }

        return highest;
    }

    /*
     * TC: O(n)
     * SC: O(1)
     */

     public static void main(String[] args) {
        HighestAltitude ha = new HighestAltitude();

        // Test case 1: General case
        int[] gain1 = { -5, 1, 5, 0, -7 };
        System.out.println("Test case 1: " + ha.largestAltitude(gain1)); // Expected output: 1

        // Test case 2: All positive gains
        int[] gain2 = { 1, 2, 3, 4, 5 };
        System.out.println("Test case 2: " + ha.largestAltitude(gain2)); // Expected output: 15

        // Test case 3: All negative gains
        int[] gain3 = { -1, -2, -3, -4, -5 };
        System.out.println("Test case 3: " + ha.largestAltitude(gain3)); // Expected output: 0

        // Test case 4: Mixed gains
        int[] gain4 = { 3, -4, 2, -1, 4, -2 };
        System.out.println("Test case 4: " + ha.largestAltitude(gain4)); // Expected output: 4

        // Test case 5: Single element gain
        int[] gain5 = { 10 };
        System.out.println("Test case 5: " + ha.largestAltitude(gain5)); // Expected output: 10

        // Test case 6: Empty gain array
        int[] gain6 = {};
        System.out.println("Test case 6: " + ha.largestAltitude(gain6)); // Expected output: 0
    }
}
