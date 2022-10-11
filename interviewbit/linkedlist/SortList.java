package interviewbit.linkedlist;

import java.util.PriorityQueue;

/*
Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5
 */
public class SortList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(5);
        A.next = A1;
        ListNode A2 = new ListNode(4);
        A1.next = A2;
        ListNode A3 = new ListNode(3);
        A2.next = A3;

        System.out.println(sortList(A));
    }

    public static ListNode sortList(ListNode A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode current = A;
        while (current != null) {
            pq.add(current.val);
            current = current.next;
        }

        ListNode temp = new ListNode(pq.poll());
        A = temp;
        while (!pq.isEmpty()) {
            ListNode node = new ListNode(pq.poll());
            temp.next = node;
            temp = temp.next;
        }
        return A;
    }
}
