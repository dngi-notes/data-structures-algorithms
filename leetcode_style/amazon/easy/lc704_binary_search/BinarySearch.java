package amazon.easy.lc704_binary_search;

public class BinarySearch {
    /*
     * Given an array of integers nums which is sorted in ascending order, and an
     * integer target, write a function to search target in nums. If target exists,
     * then return its index. Otherwise, return -1.
     * 
     * You must write an algorithm with O(log n) runtime complexity.
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        String output = "Output: ";

        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        System.out.println(output + bs.search(nums1, 9)); // expected: 4

        int[] nums2 = nums1;
        System.out.println(output + bs.search(nums2, 2)); // expected -1
    }
}
