package google.medium.lc_17_letter_combinations_of_phone_number;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent. Return the answer in any order.
    A mapping of digits to letters (just like on the telephone buttons) is given below. 
    Note that 1 does not map to any letters.

    e.g. 1
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();

        Map<Character, String> phoneLookup = new HashMap<>();
        phoneLookup.put('2', "abc");
        phoneLookup.put('3', "def");
        phoneLookup.put('4', "ghi");
        phoneLookup.put('5', "jkl");
        phoneLookup.put('6', "mno");
        phoneLookup.put('7', "pqrs");
        phoneLookup.put('8', "tuv");
        phoneLookup.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        backtrack(digits, phoneLookup, result, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(String digits, Map<Character, String> phoneLookup, List<String> result, StringBuilder sb, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letters = phoneLookup.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            sb.append(letter);
            backtrack(digits, phoneLookup, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
