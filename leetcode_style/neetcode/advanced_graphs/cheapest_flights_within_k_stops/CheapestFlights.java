package neetcode.advanced_graphs.cheapest_flights_within_k_stops;

import java.util.*;

public class CheapestFlights {
    /*
     * There are n cities connected by some number of flights. You are given an
     * array flights where flights[i] = [fromi, toi, pricei] indicates that there is
     * a flight from city fromi to city toi with price pricei.
     * 
     * You are also given three integers src, dst, and k, return the cheapest price
     * from src to dst with at most k stops. If there is no such route, return -1.
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        if(flights == null || flights.length == 0 || flights[0].length == 0 || n == 0) {
            return -1;
        }

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.computeIfAbsent(from, key -> new ArrayList<>()).add(new int[]{to, price});
        }

        // Priority Queue: (price, current city, number of stops so far)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int currentCity = current[1];
            int stops = current[2];

            if(currentCity == dest) {
                return cost;
            }

            if(stops <= k) {
                List<int[]> neighbors = graph.getOrDefault(currentCity, new ArrayList<>());
                for(int[] neighbor : neighbors) {
                    int nextCity = neighbor[0];
                    int price = neighbor[1];
                    pq.offer(new int[]{cost + price, nextCity, stops + 1});
                }
            }
        }

        return -1;
    }
}
