package linked_lists.lc328_odd_even_linked_list;

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

public class OddEvenList {
    /*
     * Given the head of a singly linked list, group all the nodes with odd indices
     * together followed by the nodes with even indices, and return the reordered
     * list.
     * 
     * The first node is considered odd, and the second node is even, and so on.
     * 
     * Note that the relative order inside both the even and odd groups should
     * remain as it was in the input.
     * 
     * You must solve the problem in O(1) extra space complexity and O(n) time
     * complexity.
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        OddEvenList oel = new OddEvenList();
        String output = "Output: ";

        /* Example */
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println(output + oel.oddEvenList(head1).toString()); // Expected Output: 1 -> 3 -> 5 -> 2 -> 4

        /* Example 2 */
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(5);
        head2.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next.next = new ListNode(7);
        System.out.println(output + oel.oddEvenList(head2).toString()); // expected output 2, 3, 6, 7, 1, 5, 4

        /* null test */
        ListNode head3 = null;
        System.out.println(output + oel.oddEvenList(head3));

    }
}
