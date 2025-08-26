package google.lc_346_moving_average_from_data_stream;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Given a stream of integers and a window size, calculate the moving average of
 * all integers in the sliding window.
 * 
 * Example 1:
 * MovingAverage m = new MovingAverage(3);
 * 
 * m.next(1) = 1 // return 1.00000
 * m.next(10) = (1 + 10) / 2 // return 5.50000
 * m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
 * m.next(5) = (10 + 3 + 5) / 3 // return 6.00000
 */

public class Solution {
    private int size;
    private double sum;
    private Queue<Integer> window;

    /**
     * @param size: int
     */
    public Solution(int size) {
        this.size = size;
        sum = 0;
        window = new LinkedList<>();
    }

    /**
     * @param val: int
     * @return
     */
    public double next(int val) {
        if (window.size() == size) {
            sum -= window.remove();
        }

        window.offer(val);
        sum += val;
        return sum / window.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution(3);
        System.out.println(s.next(1));
        System.out.println(s.next(10));
        System.out.println(s.next(3));
        System.out.println(s.next(5));
    }
}
