package neetcode.advanced_graphs.lc332_reconstruct_itinerary;

import java.util.*;

public class ReconstructItinerary {
    /*
     * You are given a list of airline tickets where tickets[i] = [fromi, toi]
     * represent the departure and the arrival airports of one flight. Reconstruct
     * the itinerary in order and return it.
     * 
     * All of the tickets belong to a man who departs from "JFK", thus, the
     * itinerary must begin with "JFK". If there are multiple valid itineraries, you
     * should return the itinerary that has the smallest lexical order when read as
     * a single string.
     * 
     * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
     * ["JFK", "LGB"].
     * You may assume all tickets form at least one valid itinerary. You must use
     * all the tickets once and only once.
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> itinerary = new ArrayList<>();
        if(tickets == null || tickets.isEmpty()) {
            return itinerary;
        }

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket: tickets) {
            graph.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<>()).add(ticket.get(1));
        }

        buildItinerary("JFK", graph, itinerary);
        return itinerary;
    }
    
    private void buildItinerary(String airport, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);

        while(destinations != null && !destinations.isEmpty()) {
            String currentDestination = destinations.poll();
            buildItinerary(currentDestination, graph, itinerary);
        }

        itinerary.add(0, airport);
    }

    /*
     * Time Complexity: O(E log E)
     * Space Complexity: O(V + E)
     */

    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();
        String output = "Output: ";
        
        List<List<String>> tickets1 = Arrays.asList(
            Arrays.asList("MUC", "LHR"),
            Arrays.asList("JFK", "MUC"),
            Arrays.asList("SFO", "SJC"),
            Arrays.asList("LHR", "SFO")
        );
        System.out.println(output + ri.findItinerary(tickets1));

        List<List<String>> tickets2 = Arrays.asList(
            Arrays.asList("JFK", "SFO"),
            Arrays.asList("JFK", "ATL"),
            Arrays.asList("SFO", "ATL"),
            Arrays.asList("ATL", "JFK"),
            Arrays.asList("ATL", "SFO")
        );
        System.out.println(output + ri.findItinerary(tickets2));
    }
}