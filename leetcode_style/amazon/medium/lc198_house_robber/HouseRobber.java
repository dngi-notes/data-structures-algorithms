package amazon.medium.lc198_house_robber;

public class HouseRobber {
    public int robRecursive(int[] nums) {
        return robRecursiveHelper(nums, nums.length - 1);
    }

    public int robRecursiveHelper(int nums[], int index) {
        if(index < 0) {
            return 0;
        }

        if(index == 0) {
            return nums[0];
        }

        return Math.max(nums[index] + robRecursiveHelper(nums, index - 2), robRecursiveHelper(nums, index - 1));
    }

    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        String output = "Output: ";

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(output + robber.robRecursive(nums1)); // expected: 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(output + robber.robRecursive(nums2)); // expected: 12
    }
}
