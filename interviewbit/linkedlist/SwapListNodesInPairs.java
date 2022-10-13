package interviewbit.linkedlist;

public class SwapListNodesInPairs {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode A1 = new ListNode(2);
        A.next = A1;
        ListNode A2 = new ListNode(3);
        A1.next = A2;
        ListNode A3 = new ListNode(4);
        A2.next = A3;
        ListNode A4 = new ListNode(5);
        A3.next = A4;

        System.out.println(swapPairs(A));
    }

    private static ListNode swapPairs(ListNode A) {
        ListNode current = A;
        ListNode pointer = A;

        int a = 0;
        int b = 0;

        while (current != null && pointer != null) {
            pointer = current.next;
            if (pointer != null) {
                a = current.val;
                b = pointer.val;
                current.val = b;
                pointer.val = a;
                current = current.next.next;
            }
        }
        return A;
    }


    public static ListNode swapPairs1(ListNode A) {
        ListNode currentHead;
        ListNode previous;
        ListNode current = A;
        ListNode further = A;
        ListNode previousTail = A;

        boolean check = true;

        while (further != null) {
            currentHead = current;
            previous = null;
            int count = 0;
            while (count < 2 && current != null) {
                further = further.next;
                current.next = previous;
                previous = current;
                current = further;
                count++;
            }

            if (check) {
                A = previous;
                check = false;
            } else {
                previousTail.next = previous;
                previousTail = currentHead;
            }
        }
        return A;
    }

    /*

    public class Solution {
        public ListNode swapPairs(ListNode A) {

            ListNode curr=A;
            ListNode ptr=A;
            int a=0, b=0;
            while(curr!=null && ptr!=null)
            {
                ptr=curr.next;
                if(ptr!=null)
                {
                    a=curr.val;
                    b=ptr.val;
                    curr.val=b;
                    ptr.val=a;
                    curr=curr.next.next;
                }
            }
            return A;


        }
    }


     */
}
