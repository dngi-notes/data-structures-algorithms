/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 *  Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */
import java.util.Objects;

class GCDOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if(!(Objects.equals(str1 + str2, str2 + str1))) {
            return "";
        }

        int len1 = str1.length();
        int len2 = str2.length();

        while(len2 != 0) {
            int temp = len2;
            len2 = len1 % len2;
            len1 = temp;
        }
        return str1.substring(0, len1);
        
    }

    public static void main(String[] args) {
        GCDOfStrings gcd = new GCDOfStrings();

        String str1 = "ABABAB";
        String str2 = "ABAB";

        String str3 = "LEET";
        String str4 = "CODE";

        String str5 = "ABCABC";
        String str6 = "ABC";

        System.out.println(gcd.gcdOfStrings(str1, str2));
        System.out.println(gcd.gcdOfStrings(str3, str4));
        System.out.println(gcd.gcdOfStrings(str5, str6));
    }
}

/**
 * Time Complexity: O(n + m)
 */