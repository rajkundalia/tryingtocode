package interviewbit.linkedlist;

/*
Given a linked list A of length N and an integer B.
You need to find the value of the Bth node from the middle towards the beginning of the Linked List A.
If no such element exists, then return -1.
NOTE:
Position of middle node is: (N/2)+1, where N is the total number of nodes in the list.

Problem Constraints
1 <= N <= 105
1<= Value in Each Link List Node <= 103
1 <= B <= 105

Input Format
First argument is the head pointer of the linkedlist A.
Second argument is an integer B.

Output Format
Return an integer denoting the value of the Bth from the middle towards the head of the linked list A.
If no such element exists, then return -1.

Example Input
Input 1:
 A = 3 -> 4 -> 7 -> 5 -> 6 -> 1 6 -> 15 -> 61 -> 16
 B = 3
 Input 2:
 A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
 B = 2
 Input 3:
 A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
 B = 10

Example Output
Output 1:
 4
 Output 2:
 14
 Output 3:
 -1

Example Explanation
Explanation 1:
 The Middle of the linked list is the node with value 6.
 The 1st node from the middle of the linked list is the node with value 5.
 The 2nd node from the middle of the linked list is the node with value 7.
 The 3rd node from the middle of the linked list is the node with value 4.
 So we will output 4.
Explanation 2:
 The Middle of the linked list is the node with value 16.
 The 1st node from the middle of the linked list is the node with value 6.
 The 2nd node from the middle of the linked list is the node with value 14.
 So we will output 14.
Explanation 3:
 The Middle of the linked list is the node with value 16.
 There are only 3 nodes to the left of the middle node and we need to find the 10th node which doesn't
 exist so we will return -1.
 */
public class KthNodeFromMiddle {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(14);
        A.next = A1;
        ListNode A2 = new ListNode(6);
        A1.next = A2;
        ListNode A3 = new ListNode(16);
        A2.next = A3;
        ListNode A4 = new ListNode(4);
        A3.next = A4;
        ListNode A5 = new ListNode(10);
        A4.next = A5;
        System.out.println(solve(A, 2));
    }

    public static int solve(ListNode A, int B) {

        if (A == null) {
            return -1;
        }

        ListNode t = A;
        int len = 0;

        while (t != null) {
            len++;
            t = t.next;
        }

        if (B > (len / 2)) {
            return -1;
        }

        int target = (len / 2) - B;

        t = A;

        for (int i = 0; i < target; i++) {
            t = t.next;
        }

        return t.val;
    }
}
