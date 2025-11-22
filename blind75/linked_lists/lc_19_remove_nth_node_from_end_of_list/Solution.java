package blind75.linked_lists.lc_19_remove_nth_node_from_end_of_list;

import data_structures.ListNode;

public class Solution {
    /**
     * given the head of a linked list 'head',
     * remove the 'n_th' node from the end of the list and return its head
     * 
     * e.g.
     * in: head = [1, 2, 3, 4, 5], n = 2
     * out: [1, 2, 3, 5]
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode follow = dummy;
        
        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            follow = follow.next;
        }

        follow.next = follow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode sample = ListNode.createSampleListNode();
        System.out.println(sample.toString());
        System.out.println(sol.removeNthFromEnd(sample, 2));
    }
}