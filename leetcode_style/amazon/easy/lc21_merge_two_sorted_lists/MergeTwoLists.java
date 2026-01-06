package amazon.easy.lc21_merge_two_sorted_lists;

import data_structures.ListNode;

public class MergeTwoLists {
    /*
     * You are given the heads of two sorted linked lists list1 and list2.
     * 
     * Merge the two lists into one sorted list. The list should be made by splicing
     * together the nodes of the first two lists.
     * 
     * Return the head of the merged linked list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        if (list1 == null) {
            tail.next = list2;
        } else if (list2 == null) {
            tail.next = list1;
        } else {
            return null;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoLists mtl = new MergeTwoLists();
        String output = "Output: ";

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);

        System.out.println(output + mtl.mergeTwoLists(l1, l2));
    }
}
