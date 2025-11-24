package data_structures;

import java.util.ArrayList;
import java.util.List;

public class Node {
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
        sb.append("Node{" + "val=" + val + ", neighbors=[");
        for (Node n : neighbors) {
            sb.append(n.val).append(",");
        }
        if (!neighbors.isEmpty()) sb.setLength(sb.length() - 1);
        sb.append("]}");
        return sb.toString();
    }
}
