package interviewbit.linkedlist;

/*
Given a linked list and a value x, partition it such that all nodes less than x come before
nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,

Given 1->4->3->2->5->2 and x = 3,

return 1->2->2->4->3->5.
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode A = new ListNode(3);
        ListNode A1 = new ListNode(2);
        A.next = A1;
        ListNode A2 = new ListNode(3);
        A1.next = A2;
        ListNode A3 = new ListNode(1);
        A2.next = A3;
        System.out.println(partition(A, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode hs = null; // head smaller
        ListNode hg = null; // head greater
        ListNode ts = null; // temp smaller
        ListNode tg = null; // temp greater

        boolean hsFound = false;
        boolean hgFound = false;

        while (head != null) {
            if (head.val < x) {
                if (!hsFound) {
                    hs = head;
                    ts = head;
                    hsFound = true;
                } else {
                    ts.next = head;
                    ts = ts.next;
                }
            } else {
                if (!hgFound) {
                    hg = head;
                    tg = head;
                    hgFound = true;
                } else {
                    tg.next = head;
                    tg = tg.next;
                }
            }
            head = head.next;
        }

        if (hs == null) {
            return hg;
        }

        if (hg == null) {
            return hs;
        }


        ts.next = hg;
        tg.next = null;

        return hs;
    }
}
