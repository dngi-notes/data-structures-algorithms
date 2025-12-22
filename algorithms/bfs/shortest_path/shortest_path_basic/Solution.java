package algorithms.bfs.shortest_path.shortest_path_basic;

import java.util.*;

/**
 * given:
 * - a unweighted graph
 * - src node
 * - a target node
 * 
 * return the length of the shortest path from src to target, else return -1
 */
public class Solution {
    public static int shortestPath(int src, int target, List<List<Integer>> graph) {
        if (graph == null || graph.isEmpty()) return -1;
        if (src == target) return 0;

        int n = graph.size();
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        q.offer(src);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int nei : graph.get(curr)) {
                if (dist[nei] == -1) {
                    dist[nei] = dist[curr] + 1;
                    q.offer(nei);
                }

                if (nei == target) {
                    return dist[nei];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(
            List.of(1, 2),
            List.of(0, 3),
            List.of(0),
            List.of(1)
        );

        System.out.println(shortestPath(0, 3, graph)); // expected: 2
        System.out.println(shortestPath(2, 3, graph));  // expected: 3
        System.out.println(shortestPath(3, 2, graph)); // expected: 3
        System.out.println(shortestPath(0, 0, graph)); // expected: 0
    }
}
