package neetcode.advanced_graphs.lc743_network_delay_time;

import java.util.*;

public class NetworkDelay {
    /*
     * You are given a network of n nodes, labeled from 1 to n. You are also given
     * times, a list of travel times as directed edges times[i] = (ui, vi, wi),
     * where ui is the source node, vi is the target node, and wi is the time it
     * takes for a signal to travel from source to target.
     * 
     * We will send a signal from a given node k. Return the minimum time it takes
     * for all the n nodes to receive the signal. If it is impossible for all the n
     * nodes to receive the signal, return -1.
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        if(times == null || times.length == 0 || times[0].length == 0) {
            return -1;
        }

        /*
         * Map each starting node to its destination and the weight (time taken to travel)
         * e.g. {2: [1, 1]}
         */
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge : times) {
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];
            graph.computeIfAbsent(node1, key -> new ArrayList<>()).add(new int[]{node2, weight});
        }

        // initialising priortiy queue with the source node k and distance 0 (sorted by distance)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));
        pq.offer(new int[]{k, 0});
        
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDistance = current[1];

            if(currentDistance > distance[node]) {
                continue;
            }

            if(graph.containsKey(node)) {
                for(int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    int newDistance = currentDistance + weight;

                    if(newDistance < distance[nextNode]) {
                        distance[nextNode] = newDistance;
                        pq.offer(new int[]{nextNode, newDistance});
                    }
                }
            }
        }
        int maxTime = Arrays.stream(distance).skip(1).max().getAsInt(); 
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }

    /*
     * Time Complexity: O(E log(V))
     * Space Complexity: O(V + E), due to the hashmap
     */
}
