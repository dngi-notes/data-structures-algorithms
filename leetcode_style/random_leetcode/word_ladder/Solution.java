package random_leetcode.word_ladder;

import java.util.*;

public class Solution {
    /**
     * A transformation sequence from word beginWord to word endWord using a
     * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
     * such that:
     * 
     * Every adjacent pair of words differs by a single letter.
     * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to
     * be in wordList.
     * sk == endWord
     * 
     * Given two words, beginWord and endWord, and a dictionary wordList, return the
     * number of words in the shortest transformation sequence from beginWord to
     * endWord, or 0 if no such sequence exists.
     * 
     * Example 1:
     * 
     * Input: beginWord = "hit", endWord = "cog", wordList =
     * ["hot","dot","dog","lot","log","cog"]
     * Output: 5
     * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot"
     * -> "dog" -> cog", which is 5 words long.
     * 
     * notes: 
     * - given 2 words: -> beginWord, endWord
     * - given a wordList that represents the transformation sequence
     * 
     * clarification:
     * - if endword isnt in wordList -> return 0, because we cant transform
     * - same if the wordList is null OR empty
     * 
     * approach:
     * - build an adjacency list of wildcard strings to wordList strings that match
     * - do a shortest path bfs on the map to find the shortest transformation sequence
     * - tc: O(m * n), space: O(m * n)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty() || !wordList.contains(endWord)) {
            return 0;
        }

        if (beginWord == null || beginWord.isEmpty()) {
            return 0;
        }

        Map<String, List<String>> adj = new HashMap<>();
        int n = beginWord.length();
        for (String word: wordList) {
            for (int i = 0; i < n; i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        int count = 1;
        q.offer(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return count;
                }

                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + '*' + word.substring(j + 1);
                    for (String nei : adj.getOrDefault(pattern, Collections.emptyList())) {
                        if (!visited.contains(nei)) {
                            q.offer(nei);
                            visited.add(nei);
                        }
                    }
                }
            }

            count++;
        }

        return 0;
    }
}
