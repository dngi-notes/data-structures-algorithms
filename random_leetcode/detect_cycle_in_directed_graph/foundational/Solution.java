package random_leetcode.detect_cycle_in_directed_graph.foundational;

import java.util.*;

public class Solution {
    /**
     * you're given an undirected graph with n nodes labeled 0 -> n - 1,
     * represented as an adjacency list
     * 
     * return true, if a cycle exists
     * else return false
     */
    public boolean hasCycle(int n, List<List<Integer>> adj) {
        if (adj == null || adj.isEmpty()) return false;

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                if (dfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int curr, int parent, List<List<Integer>> adj, Set<Integer> visited) {
        visited.add(curr);

        for (int nei : adj.get(curr)) {
            if (!visited.contains(nei)) {
                if (dfs(nei, curr, adj, visited)) {
                    return true;
                }
            } else if (nei != parent) {
                return true;
            }
        }

        return false;
    }
}
