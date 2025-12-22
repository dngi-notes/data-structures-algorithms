package algorithms.dfs.count_connected_components;

import java.util.*;

public class Solution {
    /**
     * given:
     *  int n: nodes labeled 0...n-1
     *  List<List<Integer>> graph: an adjacency list
     * 
     * write a function that returns the number of connected components
     */
    public static int countConnected(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                components++;
            }
        }

        return components;
    }

    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei, graph, visited);
            }
        }
    }
}
