package linked_lists.lc206_reverse_linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while(curr != null) {
            sb.append(curr.val);
            if(curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        return sb.toString();
    }
}

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


        /* Example 1 */
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        System.out.println(output + rl.reverseList(head1).toString());


        /* Example 2 (single element) */
        ListNode head2 = new ListNode(1);
        System.out.println(output + rl.reverseList(head2).toString());

        /* Example 3 (null) */
        ListNode head3 = null;
        System.out.println(output + rl.reverseList(head3));
    }
}
