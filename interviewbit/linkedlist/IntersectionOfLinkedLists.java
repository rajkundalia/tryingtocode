package interviewbit.linkedlist;

/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Problem approach completely explained :

Complete code in the hints section.
 */
public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        ListNode lastA, lastB;
        int countA, countB;

        if (A == null || B == null)
            return null;

        countA = countB = 1;

        lastA = A;
        lastB = B;

        while (lastA.next != null) {
            lastA = lastA.next;
            countA++;
        }

        while (lastB.next != null) {
            lastB = lastB.next;
            countB++;
        }

        if (!lastA.equals(lastB))
            return null;

        int diff = Math.abs(countA - countB);

        lastA = A;
        lastB = B;

        if (countA > countB) {
            while (diff-- > 0) {
                lastA = lastA.next;
            }
        } else {
            while (diff-- > 0)
                lastB = lastB.next;
        }

        while (!lastA.equals(lastB)) {
            lastA = lastA.next;
            lastB = lastB.next;
        }

        return lastA;
    }
}

