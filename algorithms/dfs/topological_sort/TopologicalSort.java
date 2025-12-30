package algorithms.dfs.topological_sort;

import java.util.*;

public class TopologicalSort {
    public static List<Integer> topoSort(int n, List<List<Integer>> graph) {
        if (graph == null || graph.isEmpty())
            return Collections.emptyList();

        boolean[] visiting = new boolean[n];
        boolean[] visited = new boolean[n];
        List<Integer> topoOrder = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i] && hasCycle(i, visiting, visited, graph, topoOrder)) {
                return Collections.emptyList();
            }
        }

        Collections.reverse(topoOrder);
        return topoOrder;
    }

    private static boolean hasCycle(int node, boolean[] visiting, boolean[] visited,
            List<List<Integer>> graph, List<Integer> order) {
        visiting[node] = true;

        for (int nei : graph.get(node)) {
            if (visiting[nei])
                return true; // has cycle
            if (!visited[nei] && hasCycle(nei, visiting, visited, graph, order))
                return true; // hasCycle
        }

        visited[node] = true;
        visiting[node] = false;
        order.add(node);
        return false;
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