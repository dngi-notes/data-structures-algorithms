package arrays_strings.lc_605_can_place_flowers;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {

                boolean left = (i == 0) || (flowerbed[i - 1] == 0);
                boolean right = (i == length - 1) || (flowerbed[i + 1] == 0);

                if (left && right) {
                    flowerbed[i] = 1;
                    count++;

                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        CanPlaceFlowers sol = new CanPlaceFlowers();

        /* Case 1 - Expected Output: true */ 
        int[] input1 = {1, 0, 0, 0, 1};
        int n1 = 1;
        System.out.println(sol.canPlaceFlowers(input1, n1));

        /* Case 2 - Expected Output: false */
        int[] input2 = {1, 0, 0, 0, 1};
        int n2 = 2;
        System.out.println(sol.canPlaceFlowers(input2, n2));

        /* Edge Case 1: empty array and n = 0 - Expected Output: true*/
        int[] input3 = {};
        int n3 = 0;
        System.out.println(sol.canPlaceFlowers(input3, n3));

        /* Edge Case 2: empty array and n >= 1 - Expected Output: false */
        int[] input4 = {};
        int n4 = 1;
        System.out.println(sol.canPlaceFlowers(input4, n4));

        /* Edge Case 3: array is all 1s and n = 0 - Expected Output: true */
        int[] input5 = {1, 1, 1, 1, 1};
        int n5 = 0;
        System.out.println(sol.canPlaceFlowers(input5, n5));

        /* Edge Case 4: array is all 1s and n >= 1 - Expected Output: false */
        int[] input6 = {1, 1, 1, 1, 1};
        int n6 = 1;
        System.out.println(sol.canPlaceFlowers(input6, n6));

        /* Edge Case 5: array is of length 1 (no flower) and n <=1 - Expected Output: true */
        int[] input7 = {0};
        int n7 = 1;
        System.out.println(sol.canPlaceFlowers(input7, n7));

        /* Edge Case 6: array is of length 1 (with flower) and n >= 1 - Expected Output: false */
        int[] input8 = {1};
        int n8 = 1;
        System.out.println(sol.canPlaceFlowers(input8, n8));

        /* Edge Case 7: array is of length 1 (no flower) and n > 1 - Expected Output: false */
        int[] input9 = {0};
        int n9 = 2;
        System.out.println(sol.canPlaceFlowers(input9, n9));

        /* Edge Case 8: all 0s but n > than possible - Expected Output: false*/
        int[] input10 = {0, 0, 0, 0, 0};
        int n10 = 3;
        System.out.println(sol.canPlaceFlowers(input10, n10));
    }
}
