package backtracking.lc17_letter_combinations_of_phone_number;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    /*
     * Given a string containing digits from 2-9 inclusive, return all possible
     * letter combinations that the number could represent. Return the answer in any
     * order.
     * 
     * A mapping of digits to letters (just like on the telephone buttons) is given
     * below. Note that 1 does not map to any letters.
     */
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        if(digits.length() == 0) {
            return combinations;
        }

        Map<Character, String> digitsToChar = new HashMap<>();
        digitsToChar.put('2', "abc");
        digitsToChar.put('3', "def");
        digitsToChar.put('4', "ghi");
        digitsToChar.put('5', "jkl");
        digitsToChar.put('6', "mno");
        digitsToChar.put('7', "pqrs");
        digitsToChar.put('8', "tuv");
        digitsToChar.put('9', "wxyz");

        getLetterCombinations(digits, digitsToChar, combinations, new StringBuilder(), 0);
        return combinations;
    }

    private void getLetterCombinations(String digits, Map<Character, String> digitsToChar, List<String> combinations, StringBuilder current, int index) {
        if(index == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        String letters = digitsToChar.get(digits.charAt(index));
        for(char letter: letters.toCharArray()) {
            current.append(letter);

            getLetterCombinations(digits, digitsToChar, combinations, current, index + 1);

            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        String output = "Output: ";

        String digits1 = "23";
        System.out.println(output + lc.letterCombinations(digits1));
    }
}
