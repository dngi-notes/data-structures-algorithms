package google.easy.lc_35_search_input_position;

public class Solution {
    /**
     * given a sorted array of distinct integers and a target value,
     * return the index if the target is found. if not,
     * return the index it would be in if it were inserted in order
     * 
     * e.g.
     * in: nums = [1, 3, 5, 6], target = 5
     * out: 2 (target 5 is at index 2)
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.printf("mid: %d%n", mid);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5)); // expected: 2
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2)); // expected: 1
    }
}
