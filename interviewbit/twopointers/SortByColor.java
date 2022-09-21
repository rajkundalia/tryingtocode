package interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: Using library sort function is not allowed.
Example :
Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]
 */
public class SortByColor {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(List.of(0, 1, 2, 0, 1, 2));
        sortColors(a);
        System.out.println(a);
    }

    public static void sortColors(ArrayList<Integer> a) {
        int i = 0;
        int j = a.size() - 1;
        for (int k = 0; k < a.size(); k++) {
            int val = a.get(k);
            if (val == 0) {
                swap(a, i, k);
                i++;
            }
        }

        for (int k = a.size() - 1; k >= 0; k--) {
            int val = a.get(k);
            if (val == 2) {
                swap(a, j, k);
                j--;
            }
        }
    }

    public static void swap(ArrayList<Integer> a, int i, int j) {
        Collections.swap(a, i, j);
    }
}
