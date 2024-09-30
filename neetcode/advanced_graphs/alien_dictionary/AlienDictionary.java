package neetcode.advanced_graphs.alien_dictionary;

import java.util.*;

public class AlienDictionary {
    /*
     * There is a foreign language which uses the latin alphabet, but the order
     * among letters is not "a", "b", "c" ... "z" as in English.
     * 
     * You receive a list of non-empty strings words from the dictionary, where the
     * words are sorted lexicographically based on the rules of this new language.
     * 
     * Derive the order of letters in this language. If the order is invalid, return
     * an empty string. If there are multiple valid order of letters, return any of
     * them.
     * 
     * A string a is lexicographically smaller than a string b if either of the
     * following is true:
     * 
     * The first letter where they differ is smaller in a than in b.
     * There is no index i such that a[i] != b[i] and a.length < b.length.
     */
    public String alienDictionary(String[] words) {
        // create an adjacency list and indegree array
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // initialise indegree array/map for all unique characters from words
        for(String word: words) {
            for(char ch: word.toCharArray()) {
                inDegree.putIfAbsent(ch, 0); // e.g. words = ["z", "o"] -> inDegree = {z: 0, o: 0}
            }
        }

        // building the graph by comparing adjacent words
        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // edge case for invalid input
            if(word1.length() > word2.length() && word2.startsWith(word1)) {
                return "";
            }

            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char parent = word1.charAt(j);
                char child = word2.charAt(j);
                if(parent != child) {
                    graph.computeIfAbsent(parent, key -> new ArrayList<>());
                    if(!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree.put(child, inDegree.get(child) + 1);
                    }

                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for(char ch : inDegree.keySet()) {
            if(inDegree.get(ch) == 0) {
                queue.add(ch);
            }
        }

        while(!queue.isEmpty()) {
            char currentChar = queue.poll();
            result.append(currentChar);

            if(graph.containsKey(currentChar)) {
                for(char neighbor : graph.get(currentChar)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if (inDegree.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        if(result.length() != inDegree.size()) {
            return "";
        }

        return result.toString();
    }

    public static void main(String[] args) {
        AlienDictionary ad = new AlienDictionary();
        String output = "Output: ";

        String[] words1 = {"z", "o"};
        System.out.println(output + ad.alienDictionary(words1));

        String[] words2 = {"hrn", "hrf", "er", "enn", "rfnn"};
        System.out.println(output + ad.alienDictionary(words2));
    }
}
