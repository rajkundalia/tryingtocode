package interviewbit.twopointers;

import java.util.ArrayList;
import java.util.List;

/*
Given an array and a value, remove all the instances of that value in the array.

Also return the number of elements left in the array after the operation.

It does not matter what is left beyond the expected length.

Example:

If array A is [4, 1, 1, 2, 1, 3]

and value elem is 1,

then new length is 3, and A is now [4, 2, 3]

Try to do it in less than linear additional space complexity.
 */
public class RemoveElementFromArray {
    public static void main(String[] args) {
        System.out.println(removeElement(new ArrayList<>(List.of(4, 1, 1, 2, 1, 3)), 1));
    }

    public static int removeElement(ArrayList<Integer> a, int b) {
        int count = 0;
        for (int c : a) {
            if (c != b) {
                a.set(count, c);
                count++;
            }
        }
        return count;
    }

    /*
    This contains the list as well.

    public int removeElement(ArrayList<Integer> a, int b) {
        int n = a.size();
        int i, j;

        for (i=0, j=0; j<n; j++)
        {
            if (a.get(j) != b)
            {
                a.set(i, a.get(j));
                i++;
            }
        }
        int k = i;
        while(k<a.size())  {
            a.remove(k);
        }

        return i;
    }
     */
}
