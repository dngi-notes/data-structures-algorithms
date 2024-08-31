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
            sb.setLength(sb.length() - 1);
        }
        sb.append("]}");
        return sb.toString();
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();
        return deepCopy(node, oldToNew);
    }

    private Node deepCopy(Node node, Map<Node, Node> oldToNew) {
        /*
         * if the map contains the key without node
         * return the node from the map
         * 
         * add the node to the map
         * 
         * 
         * for all the neighbors
         * assign the neighbors to their nodes
         * 
         * 
         * return the newNode
         */
        
        if(node == null) {
            return null;
        }

        if(oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        Node newNode = new Node(node.val);
        oldToNew.put(node, newNode);

        for(Node neighbor: node.neighbors) {
            newNode.neighbors.add(deepCopy(neighbor, oldToNew));
        }
        return newNode;
    }

    public static void main(String[] args) {
        CloneGraph cg = new CloneGraph();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);

        Node result = cg.cloneGraph(node2);
        System.out.println(result.toString());
    }
}