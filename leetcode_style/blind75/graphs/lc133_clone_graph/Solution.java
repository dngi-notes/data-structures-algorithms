package blind75.graphs.lc133_clone_graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import data_structures.Node;

public class Solution {
    /**
     * Given a reference of a node in a connected undirected graph.
     * 
     * Return a deep copy (clone) of the graph.
     * 
     * Each node in the graph contains a value (int) and a list (List[Node]) of its
     * neighbors.
     * 
     * class Node {
     * public int val;
     * public List<Node> neighbors;
     * }
     * 
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> originalToCopy = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        originalToCopy.put(node, new Node(node.val));
        q.offer(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node nei : curr.neighbors) {
                if (!originalToCopy.containsKey(nei)) {
                    originalToCopy.put(nei, new Node(nei.val));
                    q.add(nei);
                }

                originalToCopy.get(curr).neighbors.add(originalToCopy.get(nei));
            }
        }

        return originalToCopy.get(node);
    }
}