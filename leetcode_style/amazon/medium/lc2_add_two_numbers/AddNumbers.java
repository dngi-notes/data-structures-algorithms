package amazon.medium.lc2_add_two_numbers;

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
        /*
         * efficient solution:
         * get the sum of each digit in the list as long as they arent null
         * factor in a carry
         * 
         */
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

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
        String output = "output: ";

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(output + ad.addTwoNumbers(l1, l2)); // expected: 7 -> 0 -> 8

        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);

        System.out.println(output + ad.addTwoNumbers(l3, l4)); // expected: 0

        ListNode l5 = new ListNode(9);
        ListNode currl5 = l5;
        for(int i = 1; i < 7; i++) {
            currl5.next = new ListNode(9);
            currl5 = currl5.next;
        }

        ListNode l6 = new ListNode(9);
        ListNode currl6 = l6;
        for(int i = 1; i < 4; i++) {
            currl6.next = new ListNode(9);
            currl6 = currl6.next;
        }

        System.out.println(output + ad.addTwoNumbers(l5, l6)); // expected 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1

    }
}
