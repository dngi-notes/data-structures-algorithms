package google.lc_344_reverse_string;

/**
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 * 
 * You must do this by modifying the input array in-place with O(1) extra
 * memory.
 */

public class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }

        System.out.println(s);
    }

    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        s.reverseString(new char[]{'e', 'd', 'o', 'c', 't', 'e', 'e', 'l'});
    }
}