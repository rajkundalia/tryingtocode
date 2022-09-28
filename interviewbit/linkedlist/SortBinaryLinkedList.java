package interviewbit.linkedlist;

/*
Given a Linked List A consisting of N nodes.
The Linked List is binary i.e data values in the linked list nodes consist of only 0's and 1's.
You need to sort the linked list and return the new linked list.
NOTE:
Try to do it in constant space.

Problem Constraints
 1 <= N <= 105
 A.val = 0 or A.val = 1

Input Format
First and only argument is the head pointer of the linkedlist A.

Output Format
Return the head pointer of the new sorted linked list.

Example Input
Input 1:
 1 -> 0 -> 0 -> 1
Input 2:
 0 -> 0 -> 1 -> 1 -> 0
Example Output
Output 1:
 0 -> 0 -> 1 -> 1
Output 2:
 0 -> 0 -> 0 -> 1 -> 1

Example Explanation
Explanation 1:

 The sorted linked list looks like:
  0 -> 0 -> 1 -> 1
Explanation 2:

 The sorted linked list looks like:
  0 -> 0 -> 0 -> 1 -> 1
 */
public class SortBinaryLinkedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(0);
        A.next = A1;
        ListNode A2 = new ListNode(0);
        A1.next = A2;
        ListNode A3 = new ListNode(1);
        A2.next = A3;
        System.out.println(A);

        System.out.println(solve(A));
    }

    public static ListNode solve(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        int countZero = 0;
        int countOne = 0;

        ListNode temp = A;
        while (temp != null) {
            if (temp.val == 0) {
                countZero++;
            } else {
                countOne++;
            }
            temp = temp.next;
        }
        temp = A;

        while (countZero > 0) {
            temp.val = 0;
            temp = temp.next;
            countZero--;
        }

        while (countOne > 0) {
            temp.val = 1;
            temp = temp.next;
            countOne--;
        }
        return A;
    }

}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
