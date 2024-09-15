package graphs.dfs.lc1466_reorder_routes_to_make_paths_lead_to_zero;

import java.util.List;
import java.util.ArrayList;


public class ReorderPaths {
    /*
     * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there
     * is only one way to travel between two different cities (this network form a
     * tree). Last year, The ministry of transport decided to orient the roads in
     * one direction because they are too narrow.
     * 
     * Roads are represented by connections where connections[i] = [ai, bi]
     * represents a road from city ai to city bi.
     * 
     * This year, there will be a big event in the capital (city 0), and many people
     * want to travel to this city.
     * 
     * Your task consists of reorienting some roads such that each city can visit
     * the city 0. Return the minimum number of edges changed.
     * 
     * It's guaranteed that each city can reach city 0 after reorder.
     */
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] conn : connections) {
            graph.get(conn[0]).add(conn[1]);
            graph.get(conn[1]).add(conn[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(0, connections, visited, graph);
    }

    private int dfs(int node, int[][] connections, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        int count = 0;

        for(int neighbor: graph.get(node)) {
            if(!visited[neighbor]) {
                for(int[] conn: connections) {
                    if(conn[0] == node && conn[1] == neighbor) {
                        count++;
                    }
                }
                count += dfs(neighbor, connections, visited, graph);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ReorderPaths rp = new ReorderPaths();
        String output = "Output: ";

        int[][] connections1 = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(output + rp.minReorder(6, connections1));
    }
}
