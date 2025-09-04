package google.medium.lc_19_remove_nth_node_from_end_of_list;

import data_structures.ListNode;

/**
 * given the head of a linked list,
 * remove the `nth` node from the end of the list, 
 * and return its head
 * 
 * e.g.
 * input: head = [1, 2, 3, 4, 5], n = 2
 * output: [1, 2, 3, 5],
 * because we remove the second node from the end which is node n-2 = 4
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode follow = dummy;
        ListNode lead = head;

        while (n > 0 && lead != null) {
            lead = lead.next;
            n--;
        }

        while (lead != null) {
            follow = follow.next;
            lead = lead.next;
        }

        follow.next = follow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.createSampleListNode();
        System.out.println(s.removeNthFromEnd(head, 2));
        System.out.println(s.removeNthFromEnd(new ListNode(1), 1));
        System.out.println(s.removeNthFromEnd(new ListNode(1, new ListNode(2)), 1));
}
}