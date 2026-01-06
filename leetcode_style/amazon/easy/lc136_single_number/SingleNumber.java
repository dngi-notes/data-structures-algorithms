package amazon.easy.lc136_single_number;

import java.util.*;

public class SingleNumber {
    /*
     * Given a non-empty array of integers nums, every element appears twice except
     * for one. Find that single one.
     * 
     * You must implement a solution with a linear runtime complexity and use only
     * constant extra space.
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numberFrequency = new HashMap<>();
        for(int num : nums) {
            numberFrequency.put(num, numberFrequency.getOrDefault(num, 0) + 1);   
        }
        
        for(int num : numberFrequency.keySet()) {
            if(numberFrequency.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }
}
