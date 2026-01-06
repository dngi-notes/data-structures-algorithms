package neetcode.graphs.valid_tree;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValidTree {
    /*
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
     * edge is a pair of nodes), write a function to check whether these edges make
     * up a valid tree.
     */
    public boolean validTree(int n, int[][] edges) {
        /*
         * make an adjacency list of nodes from 0 -> n-1
         * map the nodes to the nodes connected to them (forming their edges)
         * 
         * check if the edges make a valid tree
         * by checking if we can visit every node in the tree
         */
        if(edges.length != n - 1) {
            return false;
        }

        
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        for(int i = 0; i < n; i++) {
            adjacency.put(i, new ArrayList<>());
        }
        
        for(int[] pair: edges) {
            adjacency.get(pair[0]).add(pair[1]);
            adjacency.get(pair[1]).add(pair[0]);
        }

        boolean[] visited = new boolean[n];

        if(!dfs(0, -1, adjacency, visited)) {
            return false;
        }

        for(boolean v : visited) {
            if(!v) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> adjacency, boolean[] visited) {
        visited[node] = true;

        for(int neighbor : adjacency.get(node)) {
            if(neighbor == parent) {
                continue;
            }

            if(visited[neighbor]) {
                return false;
            }

            if(!dfs(neighbor, node, adjacency, visited)) {
                return false;
            }
        }
        return true;
    }

    /*
     * Time Complexity: O(V + E)
     * Space Complexity O(V + E)
     */

    public static void main(String[] args) {
        
    }
}

