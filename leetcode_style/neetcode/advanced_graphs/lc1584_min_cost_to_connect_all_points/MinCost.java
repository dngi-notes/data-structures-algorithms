package neetcode.advanced_graphs.lc1584_min_cost_to_connect_all_points;

import java.util.*;

public class MinCost {
    /*
     * You are given an array points representing integer coordinates of some points
     * on a 2D-plane, where points[i] = [xi, yi].
     * 
     * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan
     * distance between them: |xi - xj| + |yi - yj|, where |val| denotes the
     * absolute value of val.
     * 
     * Return the minimum cost to make all points connected. All points are
     * connected if there is exactly one simple path between any two points.
     */
    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }

        int n = points.length; 
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[2]));
        boolean[] visited = new boolean[n];
        int edgesUsed = 0;
        int totalCost = 0;

        pq.offer(new int[]{0, 0, 0});

        while(edgesUsed < n) {
            int[] edge = pq.poll();
            int endIndex = edge[1]; // The index in points where the edge is completed
            if(visited[endIndex]) {
                continue;
            }

            visited[endIndex] = true;
            totalCost += edge[2];
            edgesUsed++;

            
            for (int nextIndex = 0; nextIndex < n; nextIndex++) {
                if(!visited[nextIndex]) {
                    int cost = manhattanDistance(points[endIndex], points[nextIndex]);
                    pq.offer(new int[]{endIndex, nextIndex, cost});
                }
            }
        }

        return totalCost;
    }

    private int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    public static void main(String[] args) {
        MinCost mc = new MinCost();
        String output = "Output: ";

        int[][] points1 = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(output + mc.minCostConnectPoints(points1));

        int[][] points2 = {{3, 12}, {-2, 5}, {-4, 1}};
        System.out.println(output + mc.minCostConnectPoints(points2));
    }
}
