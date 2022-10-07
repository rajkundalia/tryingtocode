package interviewbit.linkedlist;

/*
Given a linked list A of length N and an integer B.
You need to reverse every alternate B nodes in the linked list A.

Problem Constraints
1 <= N <= 105
1<= Value in Each Link List Node <= 103
1 <= B <= N
N is divisible by B

Input Format
First argument is the head pointer of the linkedlist A.
Second argument is an integer B.

Output Format
Return the head pointer of the final linkedlist as described.

Example Input
Input 1:
 A = 3 -> 4 -> 7 -> 5 -> 6 -> 6 -> 15 -> 61 -> 16
 B = 3
 Input 2:
 A = 1 -> 4 -> 6 -> 6 -> 4 -> 10
 B = 2

Example Output
Output 1:
 7 -> 4 -> 3 -> 5 -> 6 -> 6 -> 16 -> 61 -> 15
Output 2:
 4 -> 1 -> 6 -> 6 -> 10 -> 4

Example:
Explanation 1:
 The linked list contains 9 nodes and we need to reverse alternate 3 nodes.
 First sublist of length 3  is 3 -> 4 -> 7 so on reversing it we get 7 -> 4 -> 3.
 Second sublist of length 3 is 5 -> 6 -> 6 we don't need to reverse it.
 Third sublist of length 3 is 15 -> 61 -> 16 so on reversing it we get 16 -> 61 -> 15.
Explanation 2:
 The linked list contains 6 nodes and we need to reverse alternate 2 nodes.
 First sublist of length 2 is 1 -> 4 so on reversing it we get 4 -> 1.
 Second sublist of length 2 is 6 -> 6 we don't need to reverse it.
 Third sublist of length 2 is 4 -> 10 so on reversing it we get 10 -> 4.

 */
public class ReverseAlternateKNodes {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(4);
        A.next = A1;
        ListNode A2 = new ListNode(6);
        A1.next = A2;
        ListNode A3 = new ListNode(6);
        A2.next = A3;
        ListNode A4 = new ListNode(4);
        A3.next = A4;
        ListNode A5 = new ListNode(10);
        A4.next = A5;
        System.out.println(solve(A, 2));
    }

    public static ListNode solve(ListNode head, int k) {
        ListNode temp = head;
        ListNode newNode = null;
        ListNode last = null;

        while (temp != null) {
            ListNode current;
            ListNode previous = null;
            ListNode temp1 = temp;
            int count = 0;

            while (temp != null && count < k) {
                current = temp;
                temp = temp.next;
                current.next = previous;
                previous = current;
                count++;
            }

            temp1.next = temp;

            if (newNode == null) {
                newNode = previous;
            } else {
                last.next = previous;
            }

            if (temp == null) {
                return newNode;
            }

            count = 1;

            while (count < k) {
                temp = temp.next;
                count++;
            }

            last = temp;
            temp = temp.next;
        }
        return newNode;
    }

    public static ListNode solve1(ListNode A, int B) {
        ListNode temp = A;
        ListNode newNode = null;
        ListNode last = null;
        while (temp != null) {
            ListNode curr;
            ListNode previous = null;
            ListNode temp1 = temp;
            int count = 0;
            while (temp != null && count < B) {
                curr = temp;
                temp = temp.next;
                curr.next = previous;
                previous = curr;
                count++;
            }
            temp1.next = temp;
            if (newNode == null) {
                newNode = previous;
            } else {
                last.next = previous;
            }
            if (temp == null) {
                return newNode;
            }
            count = 1;
            while (count < B) {
                temp = temp.next;
                count++;
            }
            last = temp;
            temp = temp.next;
        }
        return newNode;
    }
}

