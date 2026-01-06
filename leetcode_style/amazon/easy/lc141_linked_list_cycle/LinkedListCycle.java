package amazon.easy.lc141_linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

import data_structures.ListNode;

public class LinkedListCycle {
    /*
     * Given head, the head of a linked list, determine if the linked list has a
     * cycle in it.
     * 
     * There is a cycle in a linked list if there is some node in the list that can
     * be reached again by continuously following the next pointer. Internally, pos
     * is used to denote the index of the node that tail's next pointer is connected
     * to. Note that pos is not passed as a parameter.
     * 
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     */
    public boolean hasCycleWithSet(ListNode head) {
        Set<ListNode> seenNodes = new HashSet<>();

        ListNode curr = head;
        while(curr != null) {
            if(seenNodes.contains(curr)) {
                return true;
            }

            seenNodes.add(curr);
            curr = curr.next;
        }

        return false;
    }

    public boolean hasCycleWithSlowFast(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if(fast.next == null || fast.next.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
