package amazon.easy.lc125_valid_palindrome;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String output = "Output: ";

        System.out.println(output + vp.isPalindrome("A man, a plan a canal: Panama")); // expected true
        System.out.println(output + vp.isPalindrome("race a car")); // expected false
        System.out.println(output + vp.isPalindrome(" ")); // expected true;
    }
}
