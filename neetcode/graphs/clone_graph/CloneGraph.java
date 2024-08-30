package neetcode.graphs.clone_graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node{val=").append(val).append(", neighbors=[");
        for (Node neighbor : neighbors) {
            sb.append(neighbor.val).append(",");
        }
        if (!neighbors.isEmpty()) {
            sb.setLength(sb.length() - 1); // Remove trailing comma
        }
        sb.append("]}");
        return sb.toString();
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        return node;
    }

   
    

    public static void main(String[] args) {
       
    }
}