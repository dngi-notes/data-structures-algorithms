package data_structures;

import java.util.LinkedList;
import java.util.Queue;

public class ListNode {
    
    private int val;
    private ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this .val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append("[");

        Queue<ListNode> queue = new LinkedList<>();
        queue.offer(this);

        while(!queue.isEmpty()) {
            ListNode current = queue.poll();

            if(current == null) {
                result.append("null");
            } else {
                result.append(current.val).append(",");
                queue.offer(current.next);
            }
        }
        
        if(result.length() > 1) {
            result.setLength(result.length() - 1);
        }

        result.append("]");

        return result.toString();
    }
}
