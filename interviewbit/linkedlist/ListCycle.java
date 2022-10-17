package interviewbit.linkedlist;

/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Try solving it using constant additional space.
Example:
Input:
              ______
             |     |
             \/    |
    1 -> 2 -> 3 -> 4
Return the node corresponding to node 3.
 */
public class ListCycle {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(2);
        A.next = A1;
        ListNode A2 = new ListNode(3);
        A1.next = A2;
        ListNode A3 = new ListNode(4);
        A2.next = A3;
        System.out.println(detectCycle(A));
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast == null) {
                return null;
            }

            fast = fast.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null) {
            return null;
        }

        fast = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
