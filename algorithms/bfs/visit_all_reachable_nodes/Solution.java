package algorithms.bfs.visit_all_reachable_nodes;

import java.util.*;

public class Solution {
    public static void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    q.offer(nei);
                    visited[nei] = true;
                }
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
        
        bfs(0, passGraph, visited);
        System.out.println(Arrays.toString(visited));
    }
}
