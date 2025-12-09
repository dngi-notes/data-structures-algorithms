package random_leetcode.detect_cycle_in_directed_graph.foundational;

import java.util.*;

public class Solution2 {
    boolean hasDirectedCycle(int n, List<List<Integer>> adj) {
        if (adj == null || adj.isEmpty()) {
            return false;
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                if(dfs(i, adj, visiting, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj, Set<Integer> visiting, Set<Integer> visited) {
        visiting.add(node);

        for (int nei : adj.get(node)) {
            if (visiting.contains(nei)) {
                return true;
            }

            else if (!visited.contains(nei)) {
                if (dfs(nei, adj, visiting, visited)) {
                    return true;
                }
            }
        }
        
        visiting.remove(node);
        visited.add(node);
        return false;
    }
}
