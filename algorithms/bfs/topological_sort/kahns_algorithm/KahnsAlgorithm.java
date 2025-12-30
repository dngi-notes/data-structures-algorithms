package algorithms.bfs.topological_sort.kahns_algorithm;

import java.util.*;

public class KahnsAlgorithm {
    public static List<Integer> topoSort(int n, List<List<Integer>> graph) {
        List<Integer> topOrder = new ArrayList<>();
        if (graph == null || graph.isEmpty()) {
            return topOrder;
        }

        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            topOrder.add(node);

            for (int nei : graph.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return topOrder.size() == n ? topOrder : List.of();
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(
                List.of(1, 2),
                List.of(3),
                List.of(),
                List.of());

        System.out.println(topoSort(4, graph)); // expected: [0, 2, 1, 3]

        List<List<Integer>> graphWithCycle = List.of(
                List.of(1, 2),
                List.of(3),
                List.of(0),
                List.of());

        System.out.println(topoSort(4, graphWithCycle)); // expected: []
    }
}
