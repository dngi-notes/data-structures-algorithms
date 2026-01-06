package random_leetcode.lc_245_shortest_word_distance_iii;

public class Solution {
    /*
     * Shortest Word Distance III
     *
     * Description:
     * Given an array of strings wordsDict and two strings word1 and word2,
     * return the shortest distance between these two words in the list.
     *
     * The catch: word1 and word2 **may be the same word**.
     *
     * If word1 == word2, you must find the shortest distance between
     * *two different occurrences* of the same word.
     *
     * The distance between two words is the absolute difference of their indices.
     *
     * You may assume both words appear at least once in the list.
     *
     * Example 1:
     *
     * Input:
     * wordsDict = ["practice", "makes", "perfect", "coding", "makes"]
     * word1 = "makes"
     * word2 = "coding"
     *
     * Output: 1
     *
     * Explanation:
     * "makes" at index 4 and "coding" at index 3 → distance = 1.
     *
     *
     * Example 2:
     *
     * Input:
     * wordsDict = ["practice", "makes", "perfect", "coding", "makes"]
     * word1 = "makes"
     * word2 = "makes"
     *
     * Output: 3
     *
     * Explanation:
     * The two closest different occurrences of "makes" are at indices 1 and 4 →
     * distance = 3.
     *
     */
    public int shortest(String[] wordsDict, String word1, String word2) {
        if (wordsDict == null || wordsDict.length == 0) {
            return Integer.MAX_VALUE;
        }

        if (word1.equals(word2)) {
            int prev = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    if (prev != -1) {
                        minDistance = Math.min(minDistance, (i - prev));
                    }

                    prev = i;
                }
            }

            return minDistance;
        }

        int idx1 = -1;
        int idx2 = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                idx1 = i;
            }
            if (wordsDict[i].equals(word2)) {
                idx2 = i;
            }

            if (isIdxValid(idx1) && isIdxValid(idx2)) {
                minDistance = Math.min(minDistance, Math.abs(idx1 - idx2));
            }
        }

        return minDistance;
    }

    private boolean isIdxValid(int idx) {
        return idx != -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] wordsDict = new String[] { "practice", "makes", "perfect", "coding", "makes" };
        System.out.println(s.shortest(wordsDict, "makes", "makes"));
        System.out.println(s.shortest(wordsDict, "practice", "coding"));
    }
}