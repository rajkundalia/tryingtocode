package interviewbit.arrays;

import java.util.List;

/*
You're given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in
linear time and constant additional space. If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example:

Input: [1, 2, 3, 1, 1]
Output: 1
1 occurs 3 times which is more than 5/3 times.

Moore's Voting Algorithm
 */
public class NBy3RepeatNumber {
    public static void main(String[] args) {
        //System.out.println(solveNBy3RepeatNumber(List.of(1, 2, 3, 1, 1)));
        System.out.println(solveNBy3RepeatNumber(List.of(1, 1, 1, 2, 3, 5, 7)));
    }

    /*
        Explanation:
        Moore's Voting Algorith reference.
        For N/2, the number of elements that can occur more than n/2 would only be 1.
        e.g.
        1,1,3 -> 1 can only occur more than n/2 i.e. only 1 element has a chance to occur more than n/2.
        Since array gets divided into 2 here, 2 buckets to check, 1 bucket should have n/2 elements and other bucket
        should also contain 1 elements so that N/2 is satisfied.

        Now in case of N/3, the number of elements that can occur more than N/3 would be 2.
        In case of dividing array by 3, there are chances of 2 elements being more than N/3.
        e.g. 1,1,2,2 -> 4/3 = 1, so 2 elements can make more than N/3.
        This is why here we take e1, e2 and c1 and c2.
     */
    public static int solveNBy3RepeatNumber(final List<Integer> a) {
        int e1 = Integer.MAX_VALUE;
        int e2 = Integer.MAX_VALUE;
        int c1 = 0;
        int c2 = 0;
        int n = a.size();

        for (int i = 0; i < n; i++) {
            if (a.get(i) == e1) {
                c1++;
            } else if (a.get(i) == e2) {
                c2++;
            } else if (c1 == 0) { // this loop should not be kept first, otherwise c1 and c2 both would increase for
                e1 = a.get(i);    // same element for the e.g. 1, 1, 1, 2, 3, 5, 7
                c1++;
            } else if (c2 == 0) {
                e2 = a.get(i);
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < n; i++) {
            if (a.get(i) == e1) {
                c1++;
            }
            if (a.get(i) == e2) {
                c2++;
            }
        }

        if (c1 > (n / 3)) {
            return e1;
        }

        if (c2 > (n / 3)) {
            return e2;
        }

        return -1;
    }

}
