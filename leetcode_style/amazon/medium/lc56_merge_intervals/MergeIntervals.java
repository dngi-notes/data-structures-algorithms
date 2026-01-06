package amazon.medium.lc56_merge_intervals;

import java.util.*; 

public class MergeIntervals {
    /*
     * Given an array of intervals where intervals[i] = [starti, endi], merge all
     * overlapping intervals, and return an array of the non-overlapping intervals
     * that cover all the intervals in the input.
     */

    /*
     * Example 1:
     * 
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     * Example 2:
     * 
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     */

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],  b[0]));
        List<int[]> merged = new ArrayList<>();

        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for(int[] interval : intervals) {
            int currentEnd = currentInterval[1];

            if(interval[0] <= currentEnd) {
                currentInterval[1] = Math.max(currentEnd, interval[1]);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        String output = "Output: ";

        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(output + Arrays.deepToString(mi.merge(intervals1))); // expected: [1, 6], [8, 10], [15, 18]

        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println(output + Arrays.deepToString(mi.merge(intervals2)));
    }
}