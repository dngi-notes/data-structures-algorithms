package neetcode.graphs.redundant_connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRedundant {
    /*
     * In this problem, a tree is an undirected graph that is connected and has no
     * cycles.
     * 
     * You are given a graph that started as a tree with n nodes labeled from 1 to
     * n, with one additional edge added. The added edge has two different vertices
     * chosen from 1 to n, and was not an edge that already existed. The graph is
     * represented as an array edges of length n where edges[i] = [ai, bi] indicates
     * that there is an edge between nodes ai and bi in the graph.
     * 
     * Return an edge that can be removed so that the resulting graph is a tree of n
     * nodes. If there are multiple answers, return the answer that occurs last in
     * the input.
     */
    public int[] findRedundantConnection(int[][] edges) {
        // adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int n = edges.length;
        for(int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            boolean[] visited = new boolean[n + 1];
            if(graph.containsKey(u) && graph.containsKey(v) && dfs(u, v, graph, visited)) {
                return edge;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }
    
    private boolean dfs(int source, int target, Map<Integer, List<Integer>> graph, boolean[] visited) {
        if(source == target) return true;

        visited[source] = true;
        for(int neighbor: graph.get(source)) {
            if(!visited[neighbor]) {
                if(dfs(neighbor, target, graph, visited)) {
                    return true;
                }
            }
        }

        return true;
    }
}
