package amazon.easy.lc206_reverse_linked_list;

import data_structures.ListNode;

public class ReverseList {
    /*
     * Given the head of a singly linked list, reverse the list, and return the
     * reversed list.
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ReverseList rl = new ReverseList();
        String output = "Output: ";

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        System.out.println(output + rl.reverseList(l1)); // expected 5, 4, 3, 2, 1

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);

        System.out.println(output + rl.reverseList(l2)); // expected 2, 1

        ListNode l3 = null;
        System.out.println(output + rl.reverseList(l3));
    }
}
