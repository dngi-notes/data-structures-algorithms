package linked_lists.lc2130_maximum_twin_sum_of_linked_list;

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

public class PairSum {
    /*
     * In a linked list of size n, where n is even, the ith node (0-indexed) of the
     * linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2)
     * - 1.
     * 
     * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the
     * twin of node 2. These are the only nodes with twins for n = 4.
     * The twin sum is defined as the sum of a node and its twin.
     * 
     * Given the head of a linked list with even length, return the maximum twin sum
     * of the linked list.
     */
    public int pairSum(ListNode head) {
        if(head == null || head.next == null) {
            return 0;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverseList(slow);

        int maxPair = 0;
        while(slow != null) {
            int pair = 0;
            pair += head.val + slow.val;
            
            head = head.next;
            slow = slow.next;
            maxPair = Math.max(maxPair, pair);
        }
        
        return maxPair;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

    public static void main(String[] args) {
        PairSum ps = new PairSum();
        String output = "Output: ";

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println(output + ps.pairSum(head1));

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        System.out.println(output + ps.pairSum(head2));
    }
}
