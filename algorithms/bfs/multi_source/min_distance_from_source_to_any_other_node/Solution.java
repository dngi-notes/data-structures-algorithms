package algorithms.bfs.multi_source.min_distance_from_source_to_any_other_node;

import java.util.*;

public class Solution {
    /**
     * given:
     * - an unweighted graph
     * - a list of starting nodes
     * - optional target node (ignore for now)
     * 
     * return:
     * - dist[i] = shortest distance from the nearest source
     * - else return -1
     */
    public static int[] multiSource(List<Integer> sources, List<List<Integer>> graph) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        for (int source : sources) {
            q.offer(source);
            dist[source] = 0;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();

                for (int nei : graph.get(node)) {
                    if (dist[nei] == -1) {
                        dist[nei] = dist[node] + 1;
                        q.offer(nei);
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(
                List.of(1, 2), // 0
                List.of(0, 3), // 1
                List.of(0), // 2
                List.of(1) // 3
        );

        List<Integer> sources = List.of(0, 2);
        System.out.println(Arrays.toString(multiSource(sources, graph))); // expected: [0, 1, 0, 2]
    }
}
