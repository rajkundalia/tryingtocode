package leetcode.topinterview150;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode A = new ListNode(4);
        ListNode A1 = new ListNode(11);
        A.next = A1;
        ListNode A2 = new ListNode(15);
        A1.next = A2;

        ListNode B = new ListNode(5);
        ListNode B1 = new ListNode(8);
        B.next = B1;
        ListNode B2 = new ListNode(20);
        B1.next = B2;

        System.out.println(new MergeTwoSortedLists().mergeTwoLists(A, B));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode last = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                last.next = l2;
                l2 = l2.next;
            } else {
                last.next = l1;
                l1 = l1.next;
            }
            last = last.next;
        }

        if (l1 == null) {
            last.next = l2;
        } else {
            last.next = l1;
        }

        return preHead.next;
    }
}
