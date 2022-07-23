package interviewbit.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
Example:

Input : [1, 0]
Return : [0, 1]
Lets say N = size of the array. Then, following holds true :

All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer
 */
public class RearrangeArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(3, 2, 0, 1));
        solveRearrangeArray(list);
        System.out.println(list);
    }

    /*
        Explanation:
        3,2,0,1
        o/p: 1,0,3,2

        4,0,2,1,3
        o/p: 3,4,2,0,1

        The thing is we don't have the loose the current value on the array too, so we cannot replace
        the array elements in the real time. We have to use a formula to be able to find a number at that
        position, from which the new number and the older number can be extracted.

        e.g. 3,2,0,1
        made up array:
        3+1*4 = 7
        7%4 = 3 (existing element)
        7/4 = 1 (element to be replaced)
        ---
        2+0*4 = 2
        2%4 = 2 (existing element)
        2/4 = 0 (element to be replaced)
        ---
        0+3*4 = 12
        12%4 = 0 (existing element)
        12/4 = 3 (element to be replaced)
        ---
        1+2*4 = 9
        9%4 = 1 (existing element)
        9/4 = 2 (element to be replaced)

        formula is: currentElement + (elementToBePlaced%n)*n

        final output: a[i]/n

     */
    public static void solveRearrangeArray(ArrayList<Integer> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) + ((a.get(a.get(i)) % n) * n));
        }
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) / n);
        }
    }
}
