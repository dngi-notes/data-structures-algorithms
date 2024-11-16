package neetcode.stacks.lc739_daily_temperatures;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    /*
     * Given an array of integers temperatures represents the daily temperatures,
     * return an array answer such that answer[i] is the number of days you have to
     * wait after the ith day to get a warmer temperature. If there is no future day
     * for which this is possible, keep answer[i] == 0 instead.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        String output = "Output: ";

        int[] temp1 = { 30, 40, 50, 60 };
        System.out.println(output + Arrays.toString(dt.dailyTemperatures(temp1)));

        int[] temp2 = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(output + Arrays.toString(dt.dailyTemperatures(temp2)));
    }
}
