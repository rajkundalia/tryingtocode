package interviewbit.twopointers;

import java.util.ArrayList;
import java.util.List;

/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.

TIP: C users, please malloc the result into a new array and return the result.

If the number of elements initialized in A and B are m and n respectively, the resulting size
of array A after your code is executed should be m + n

Example :

Input :
         A : [1 5 8]
         B : [6 9]

Modified A : [1 5 6 8 9]
 */
public class MergeTwoSortedListsII {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(List.of(1, 5, 8));
        ArrayList<Integer> b = new ArrayList<>(List.of(6, 9));
        merge(a,b);
        System.out.println(a);
    }

    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0;
        int j = 0;

        while (j < b.size() && i < a.size()) {
            if (a.get(i) > b.get(j)) {
                a.add(i, b.get(j));
                j++;
            }
            i++;
        }

        while (j < b.size()) {
            a.add(b.get(j));
            j++;
        }
    }
}
