package graphs.dfs.lc399_evaluate_division;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class EvaluateDivision {
    /*
     * 
     * You are given an array of variable pairs equations and an array of real
     * numbers values, where equations[i] = [Ai, Bi] and values[i] represent the
     * equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a
     * single variable.
     * 
     * You are also given some queries, where queries[j] = [Cj, Dj] represents the
     * jth query where you must find the answer for Cj / Dj = ?.
     * 
     * Return the answers to all queries. If a single answer cannot be determined,
     * return -1.0.
     * 
     * Note: The input is always valid. You may assume that evaluating the queries
     * will not result in division by zero and that there is no contradiction.
     * 
     * Note: The variables that do not occur in the list of equations are undefined,
     * so the answer cannot be determined for them.
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>(); // e.g. {"a" : {"a" : 2.0}}

        for(int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, value);
            graph.get(v).put(u, 1.0 / value);        
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            if(!graph.containsKey(src) || !graph.containsKey(dest)) {
                results[i] = -1;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, src, dest, 1.0, visited);
            }
        }

        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String src, String dest, double product, Set<String> visited) {
        if(src.equals(dest)) {
            return product;
        }

        visited.add(src);

        for(Map.Entry<String, Double> neighbor: graph.get(src).entrySet()) {
            if(!visited.contains(neighbor.getKey())) {
                double result = dfs(graph, neighbor.getKey(), dest, product * neighbor.getValue(), visited);
                if(result != -1.0) {
                    return result;
                }
            }
        }

        return - 1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision ed = new EvaluateDivision();

        // Test Case 1
        List<List<String>> equations1 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        System.out.println("Test Case 1: " + Arrays.toString(ed.calcEquation(equations1, values1, queries1))); // Expected: [6.0, 0.5, -1.0, 1.0, -1.0]

        // Test Case 2
        List<List<String>> equations2 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d")
        );
        double[] values2 = {1.0, 1.0};
        List<List<String>> queries2 = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "d"),
                Arrays.asList("a", "a"),
                Arrays.asList("c", "c")
        );
        System.out.println("Test Case 2: " + Arrays.toString(ed.calcEquation(equations2, values2, queries2))); // Expected: [-1.0, -1.0, 1.0, 1.0]

        // Test Case 3
        List<List<String>> equations3 = Arrays.asList(
                Arrays.asList("a", "a")
        );
        double[] values3 = {1.0};
        List<List<String>> queries3 = Arrays.asList(
                Arrays.asList("a", "a"),
                Arrays.asList("a", "b")
        );
        System.out.println("Test Case 3: " + Arrays.toString(ed.calcEquation(equations3, values3, queries3))); // Expected: [1.0, -1.0]
    }
}