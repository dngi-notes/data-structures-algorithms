package linked_lists.lc2095_delete_the_middle_node_of_a_linked_list;

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
                sb.append("->");
            }
            curr = curr.next;
        }
        return sb.toString();
    }
}

public class DeleteMiddle {
    /*
     * You are given the head of a linked list. Delete the middle node, and return
     * the head of the modified linked list.
     * 
     * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the
     * start using 0-based indexing,
     * where ⌊x⌋ denotes the largest integer less than or equal to x.
     * 
     * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2,
     * respectively.
     */
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null) {
            prev.next = slow.next;
        }
        
        return head;
    }

    public static void main(String[] args) {
        DeleteMiddle dm = new DeleteMiddle();
        String output = "Output: ";

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(output + dm.deleteMiddle(head).toString());

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(7);
        System.out.println(output + dm.deleteMiddle(head2).toString());

        ListNode head3 = null;
        System.out.println(output + dm.deleteMiddle(head3));

    }
}