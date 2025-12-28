package algorithms.dfs.cycle_detection.contains_cycle;

import java.util.*;

public class Solution {
    /**
     * given:
     * - an undirected graph (represented as an adjacency list)
     * 
     * return:
     * - true, if the graph contains a cycle
     * - false, if not
     */
    public static boolean hasCycle(int n, List<List<Integer>> graph) {
        if (graph == null || graph.isEmpty()) {
            return false;
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(i, -1, visited, graph)) {
                return true;
            }
        }

        return false;
    }

    private static boolean dfs(int src, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[src] = true;

        for (int nei : graph.get(src)) {
            if (visited[nei] && nei != parent) {
                return true;
            }

            if (!visited[nei] && dfs(nei, src, visited, graph)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        //graph with cycle
        List<List<Integer>> graph1 = List.of(
            List.of(1, 2),
            List.of(0, 2),
            List.of(0, 1)
        );
        // no cycle
        List<List<Integer>> graph2 = List.of(
            List.of(1),
            List.of(0)
        );
        
        System.out.println(hasCycle(3, graph1)); // expected: true
        System.out.println(hasCycle(2, graph2)); // expected: false
    }
}