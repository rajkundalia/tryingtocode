package interviewbit.linkedlist;

/*
Given a linked list A, reverse the order of all nodes at even positions.

Problem Constraints
1 <= Size of linked list <= 100000

Input Format
First and only argument is the head of the Linked-List A.

Output Format
Return the head of the new linked list.

Example Input
Input 1:
A = 1 -> 2 -> 3 -> 4
Input 2:
A = 1 -> 2 -> 3

Example Output
Output 1:
 1 -> 4 -> 3 -> 2
Output 2:
 1 -> 2 -> 3

Example:
Explanation 1:
Nodes are positions 2 and 4 have been swapped.
Explanation 2:
No swapping neccassary here.
 */
public class EvenReverse {

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(2);
        A.next = A1;
        ListNode A2 = new ListNode(3);
        A1.next = A2;
        ListNode A3 = new ListNode(4);
        A2.next = A3;
        System.out.println(solve(A));
    }

    public static ListNode solve(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode odd = head;

        // Even list
        ListNode even = null;

        // Step 1
        // Traverse the list and extract even pointing nodes in reverse order
        while (odd != null && odd.next != null) {

            // store even node in temp variable so that we don't lose a pointer
            ListNode temp = odd.next;

            // Remove the even node
            odd.next = temp.next;

            // Add even node stored in temp variable at the beginning of the even list
            temp.next = even;
            even = temp;

            // move the odd to the next odd node
            odd = odd.next;
        }

        // reset odd to the head
        odd = head;

        // Step 2 of the problem
        // add the reversed elements of the even list to the odd list
        while (even != null) {

            // store the pointer to the next even node in temp variable so that reference is not lost
            ListNode temp = even.next;

            // insert the even node between 2 odd nodes
            even.next = odd.next;
            odd.next = even;

            // move the head to the next odd node
            odd = odd.next.next;

            // set the even pointer to the next even node in the even list
            even = temp;
        }
        return head;
    }
}
