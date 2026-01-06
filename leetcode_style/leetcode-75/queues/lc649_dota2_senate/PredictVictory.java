package queues.lc649_dota2_senate;

import java.util.LinkedList;
import java.util.Queue;

public class PredictVictory {

    /*
     * In the world of Dota2, there are two parties: the Radiant and the Dire.
     * 
     * The Dota2 senate consists of senators coming from two parties. Now the Senate
     * wants to decide on a change in the Dota2 game. The voting for this change is
     * a round-based procedure. In each round, each senator can exercise one of the
     * two rights:
     * 
     * Ban one senator's right: A senator can make another senator lose all his
     * rights in this and all the following rounds.
     * Announce the victory: If this senator found the senators who still have
     * rights to vote are all from the same party, he can announce the victory and
     * decide on the change in the game.
     * Given a string senate representing each senator's party belonging. The
     * character 'R' and 'D' represent the Radiant party and the Dire party. Then if
     * there are n senators, the size of the given string will be n.
     * 
     * The round-based procedure starts from the first senator to the last senator
     * in the given order. This procedure will last until the end of voting. All the
     * senators who have lost their rights will be skipped during the procedure.
     * 
     * Suppose every senator is smart enough and will play the best strategy for his
     * own party. Predict which party will finally announce the victory and change
     * the Dota2 game. The output should be "Radiant" or "Dire".
     */
    public String predictPartyVictory(String senate) {
        if (senate == null || senate.isEmpty()) {
            return "";
        }

        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiantIndex = radiantQueue.poll();
            int direIndex = direQueue.poll();

            if (radiantIndex < direIndex) {
                radiantQueue.offer(radiantIndex + senate.length());
            } else {
                direQueue.offer(direIndex + senate.length());
            }
        }

        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static void main(String[] args) {
        PredictVictory pv = new PredictVictory();
        String output = "Output: ";

        String senate1 = "RD";
        System.out.println(output + pv.predictPartyVictory(senate1));

        String senate2 = "RDD";
        System.out.println(output + pv.predictPartyVictory(senate2));

        // Test case 3: Single senator from Radiant
        String senate3 = "R";
        System.out.println(output + pv.predictPartyVictory(senate3)); // Expected: Radiant

        // Test case 4: Single senator from Dire
        String senate4 = "D";
        System.out.println(output + pv.predictPartyVictory(senate4)); // Expected: Dire

        // Test case 5: Alternating senators
        String senate5 = "RDRD";
        System.out.println(output + pv.predictPartyVictory(senate5)); // Expected: Radiant

        // Test case 6: All Radiant
        String senate6 = "RRRR";
        System.out.println(output + pv.predictPartyVictory(senate6)); // Expected: Radiant

        // Test case 7: All Dire
        String senate7 = "DDDD";
        System.out.println(output + pv.predictPartyVictory(senate7)); // Expected: Dire

        // Test case 8: Longer sequence with mixed parties
        String senate8 = "RDDRRDR";
        System.out.println(output + pv.predictPartyVictory(senate8)); // Expected: Radiant

        // Test case 9: Edge case with immediate victory
        String senate9 = "RDDDR";
        System.out.println(output + pv.predictPartyVictory(senate9)); // Expected: Dire
    }
}
