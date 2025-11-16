package random_leetcode.lc_244_shortest_word_distance_ii;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/*
 * Shortest Word Distance II
 *
 * Description:
 * Design a class that receives a list of words upon initialization and supports 
 * efficient repeated queries for the shortest distance between any two words in the list.
 *
 * Implement the WordDistance class:
 * 
 * - WordDistance(String[] wordsDict)
 *   Initializes the object with the words in the dictionary.
 * 
 * - int shortest(String word1, String word2)
 *   Returns the shortest distance between word1 and word2.
 *
 * You may assume that word1 and word2 are in the dictionary.
 *
 * Example:
 *
 * WordDistance wordDistance = new WordDistance(
 *     new String[]{"practice", "makes", "perfect", "coding", "makes"}
 * );
 * wordDistance.shortest("coding", "practice"); // Output: 3
 * wordDistance.shortest("makes", "coding");    // Output: 1
 *
 * Explanation:
 * - The shortest distance between "coding" and "practice" is 3.
 * - The shortest distance between "makes" and "coding" is 1.
 */

public class Solution {
    private Map<String, List<Integer>> stringToIndex = new HashMap<>();

    public Solution(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            stringToIndex.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = stringToIndex.get(word1);
        List<Integer> list2 = stringToIndex.get(word2);

        int i = 0;
        int j = 0;
        int minDistance = Integer.MAX_VALUE;
        
        while (i < list1.size() && j < list2.size()) {
            int idx1 = list1.get(i);
            int idx2 = list2.get(j);

            minDistance = Math.min(minDistance, Math.abs(idx1 - idx2));
             
            if (idx1 < idx2) {
                i++;
            } else {
                j++;
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        Solution s = new Solution(wordsDict);

        System.out.println(s.shortest("makes", "coding")); //expected: 1
        System.out.println(s.shortest("coding", "practice")); // expected: 3
    }
}