package neetcode.graphs.count_connected_components;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class CountComponents {
    /*
     * There is an undirected graph with n nodes. There is also an edges array,
     * where edges[i] = [a, b] means that there is an edge between node a and node b
     * in the graph.
     * 
     * The nodes are numbered from 0 to n - 1.
     * 
     * Return the total number of connected components in that graph.
     */
    public int countComponents(int n, int[][] edges) {
        /*
         * create an adj list
         * -> map nodes [a, b] AND [b, a] (since undirected graph)
         * 
         * use a data structure to keep track of nodes we've visited (set/array)
         * 
         * search each node and keep track of count of connect components
         * 
         */
        if(edges == null || edges.length == 0 || edges[0].length == 0 || n == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] pair : edges) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

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

    private void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    /*
     * Time Complexity: O(V + E), where V is the number of nodes and E is the number
     * of edges
     * Space Complexity: O(n)
     */

    public static void main(String[] args) {
        CountComponents cc = new CountComponents();
        String output = "Output: ";

        int[][] edges1 = {{0, 1}, {1, 2}};
        System.out.println(output + cc.countComponents(3, edges1));
        
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {4, 5}};
        System.out.println(output + cc.countComponents(6, edges2));
        
        int[][] edges3 = null;
        System.out.println(output + cc.countComponents(1, edges3));
        
        int[][] edges4 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(output + cc.countComponents(0, edges4));   
    }
}
