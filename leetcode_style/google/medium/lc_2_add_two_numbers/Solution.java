package google.medium.lc_2_add_two_numbers;

import data_structures.ListNode;

/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 != null) return l2;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int digit1 = (l1 == null) ? 0 : l1.val;
            int digit2 = (l2 == null) ? 0 : l2.val;
            
            int sum  = digit1 + digit2 + carry;
            int digitToAdd = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digitToAdd);
            curr.next = newNode;
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode();
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode();
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(4);

        System.out.println(s.addTwoNumbers(l1, l2));
    }
}