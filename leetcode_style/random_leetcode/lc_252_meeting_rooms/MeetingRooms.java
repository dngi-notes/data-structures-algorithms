package random_leetcode.lc_252_meeting_rooms;

import java.util.*;

/**
 * given:
 * - intervals: int[][], intervals[i] = [start_i, end_i]
 * 
 * determine if a person can attend all meetings (if there is no overlap)
 * 
 * return:
 * - true -> if they can attend all meetings
 * - false -> if any meetings overlap
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] meetings) {
        if (meetings == null || meetings.length <= 1) return true;

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int[] curr = meetings[0];
        for (int i = 1; i < meetings.length; i++) {
            int currEnd = curr[1];
            int start = meetings[i][0];

            if (currEnd > start) {
                return false;
            }

            curr = meetings[i];
        }

        return true;
    }

    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();

        int[][] meetings1 = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(mr.canAttendMeetings(meetings1));

        int[][] meetings2 = new int[][]{{7, 10}, {2, 4}};
        System.out.println(mr.canAttendMeetings(meetings2));

        int[][] meetings3 = new int[][]{{1, 2}, {3, 4}, {3, 5}};
        System.out.println(mr.canAttendMeetings(meetings3));
    }
}
