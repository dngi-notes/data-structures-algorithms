package blind75.heaps.lc_23_merge_k_sorted_lists;

import data_structures.ListNode;
import java.util.PriorityQueue;

public class Solution {
    /**
     * you are given an array of 'k' linked-lists,
     * each linked list is sorted in ascending
     * 
     * merge all the linked listts into one sorted linked list and return it
     * 
     * e.g.
     * in: lists = [[1, 4, 5], [1, 3, 4], [2, 6]]
     * out: [1, 1, 2, 3, 4, 4, 5, 6]
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val -  b.val);
        for (ListNode head : lists) {
            while (head != null) {
                minHeap.offer(head);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(-10001);
        ListNode curr = dummy;
        while(!minHeap.isEmpty()) {
            curr.next = minHeap.poll();
            curr = curr.next;
        }
        curr.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        ListNode[] lists = new ListNode[]{ListNode.createSampleListNode(), ListNode.createSampleListNode(), ListNode.createSampleListNode()};
        System.out.println(ss.mergeKLists(lists));
    }
}
