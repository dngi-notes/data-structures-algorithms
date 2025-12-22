package algorithms.dfs.visit_all_nodes;

import java.util.*;

public class Solution {
    /**
     * write a recursive dfs that visits
     * all nodes reachable from a start node
     */
    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> passGraph = List.of(
            List.of(1, 2),
            List.of(0, 3),
            List.of(0),
            List.of(1)
        );
        boolean[] visited = new boolean[passGraph.size()];
        System.out.println(Arrays.toString(visited));
        
        dfs(0, passGraph, visited);
        System.out.println(Arrays.toString(visited));
    }
}

