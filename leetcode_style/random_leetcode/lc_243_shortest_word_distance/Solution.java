package random_leetcode.lc_243_shortest_word_distance;

public class Solution {
    /**
     * Given an array of strings `wordsDict` and two different strings `word1` and
     * `word2`, return the shortest distance between these two words in the list.
     * 
     * The distance between two words is defined as the absolute difference between
     * their indices.
     * 
     * You may assume that both words appear at least once in the list.
     * 
     * example 1:
     * wordsDict = ["practice", "makes", "perfect", "coding", "makes"]
     * word1 = "coding"
     * word2 = "practice"
     * output: 3
     * 
     * example 2:
     * wordsDict = ["practice", "makes", "perfect", "coding", "makes"]
     * word1 = "makes"
     * word2 = "coding"
     * output: 1
     */

    public int getDistance(String[] wordsDict, String word1, String word2) {
        if (wordsDict == null || wordsDict.length == 0) {
            return Integer.MAX_VALUE;
        }

        int p1 = -1;
        int p2 = -1;
        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                p1 = i;
            }

            if (wordsDict[i].equals(word2)) {
                p2 = i;
            }

            if (isIdxValid(p1) && isIdxValid(p2)) {
                shortestDistance = Math.min(shortestDistance, Math.abs(p1 - p2));
            }
        }

        return shortestDistance;
    }

    private boolean isIdxValid(int index) {
        return index != -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";

        String w3 = "makes";
        String w4 = "coding";

        System.out.println(s.getDistance(wordsDict, word1, word2));
        System.out.println(s.getDistance(wordsDict, w3, w4));
    }
}