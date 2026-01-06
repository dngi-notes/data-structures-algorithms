package blind75.linked_lists.lc_143_reorder_list;

import data_structures.ListNode;

public class Solution {
    /**
     * You are given the head of a linked list
     * the list can be represented as
     * l_0 -> l_1, -> ... -> l_n-1, l_n
     * 
     * rearrange the list to be in the following form
     * l_0 -> l_n -> l_1, l_n-1, l_2, l_n-2 ->...
     * 
     * e.g.
     * in: head = [1, 2, 3, 4]
     * out: [1, 4, 2, 3]
     */
    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode firstHalf = head;
        ListNode secondHalf = reverse(slow.next);
        slow.next = null;

        while (secondHalf != null) {
            ListNode tmp1 = firstHalf.next;
            ListNode tmp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = tmp1;

            firstHalf = tmp1;
            secondHalf = tmp2;

        }

        return head;
    }

    /**
     * helper to reverse a list
     * e.g. [1, 2, 3] -> [3, 2, 1]
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        ListNode sample = ListNode.createSampleListNode();
        System.out.println(sample);
        System.out.println("The reordered list: " + ss.reorderList(sample));
    }
}
