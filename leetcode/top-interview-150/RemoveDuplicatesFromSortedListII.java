package leetcode.topinterview150;

/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node1_2 = new ListNode(1);

        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.next = node1;
        node1.next = node1_2;

        node1_2.next = node2;
        node2.next = node3;

        System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        // Special case...
        if (head == null || head.next == null)
            return head;
        // create a fake node that acts like a fake head of list pointing to the original head and it points to the original head......
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode curr = fake;
        // Loop till curr.next and curr.next.next not null
        while (curr.next != null && curr.next.next != null) {         // curr.next means the next node of curr pointer and curr.next.next means the next of next of curr pointer...
            // if the value of curr.next and curr.next.next is same...
            // There is a duplicate value present in the list...
            if (curr.next.val == curr.next.next.val) {
                int duplicate = curr.next.val;
                // If the next node of curr is not null and its value is eual to the duplicate value...
                while (curr.next != null && curr.next.val == duplicate) {
                    // Skip those element and keep updating curr...
                    curr.next = curr.next.next;
                }
            }
            // Otherwise, move curr forward...
            else {
                curr = curr.next;
            }
        }
        return fake.next;       // Return the linked list...
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
