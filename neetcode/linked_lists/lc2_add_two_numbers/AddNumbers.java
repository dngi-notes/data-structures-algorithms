package neetcode.linked_lists.lc2_add_two_numbers;

import data_structures.ListNode;

public class AddNumbers {
    /*
     * You are given two non-empty linked lists representing two non-negative
     * integers. The digits are stored in reverse order, and each of their nodes
     * contains a single digit. Add the two numbers and return the sum as a linked
     * list.
     * 
     * You may assume the two numbers do not contain any leading zero, except the
     * number 0 itself.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l1 != null) ? l2.val : 0;
            
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            curr.next = newNode;
            curr = curr.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        AddNumbers ad = new AddNumbers();
        String output = "Output: ";

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(1);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(0);
        l2.next.next = new ListNode(2);

        System.out.println(output + ad.addTwoNumbers(l1, l2)); // expected: 3, 0, 3
    }
}
