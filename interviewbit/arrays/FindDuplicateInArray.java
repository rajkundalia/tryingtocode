package interviewbit.arrays;

import java.util.List;

/*
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear
time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:
[3 4 1 4 1]

Sample Output:
1

If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
 */
public class FindDuplicateInArray {
    public static void main(String[] args) {
        System.out.println(solveFindDuplicateInArray(List.of(3, 4, 1, 4, 1)));
    }

    /*
    Basic Approach:

    HashSet<Integer> arr = new HashSet<>();
        for(int i =0;i<A.size();i++)
        {
            if(!arr.add(A.get(i))) return A.get(i);
        }
        return -1;
     */
    // The technique done below is referenced from linked list loop detection
    public static int solveFindDuplicateInArray(final List<Integer> A) {
        int slow = A.get(0);
        int fast = A.get(A.get(0));

        while(slow != fast) {
            slow = A.get(slow);
            fast = A.get(A.get(fast));
        }
        fast = 0;
        while(slow != fast) {
            slow = A.get(slow);
            fast = A.get(fast);
        }
        return slow;
    }
}
