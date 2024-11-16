package neetcode.stacks.lc739_daily_temperatures;

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
        if(temperatures == null || temperatures.length == 0) {
            return new int[0];
        }

        for(int i = 0; i < temperatures.length; i++) {
            
        }
    }
}
