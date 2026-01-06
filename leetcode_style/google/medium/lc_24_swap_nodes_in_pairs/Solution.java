package google.medium.lc_24_swap_nodes_in_pairs;

import data_structures.ListNode;

public class Solution {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head
     * Cant modify values in the list, only nodes themselves may be changed
     */
    public ListNode swapPairsR(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairsR(second.next);
        second.next = first;
        return second;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode test = ListNode.createSampleListNode();

        System.out.println(s.swapPairsR(test));
    }
}
