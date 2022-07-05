package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note that if you end up using an additional array, you will only receive partial score.
Example:

If the array is
[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:
[
    [3, 1],
    [4, 2]
]
https://www.interviewbit.com/problems/rotate-matrix/
 */
public class RotateMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(6);
        list1.add(9);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(5);
        list2.add(8);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(4);
        list3.add(7);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        solveRotateMatrix(list);
        System.out.println(list);
    }

    public static void solveRotateMatrix(ArrayList<ArrayList<Integer>> a) {
        int n = a.get(0).size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(a, i, j);
            }
        }
        System.out.println(a);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                reverse(a, i, j, n);
            }
        }
    }

    private static void reverse(ArrayList<ArrayList<Integer>> a, int i, int j, int n) {
        int temp = a.get(i).get(j);
        a.get(i).set(j, a.get(i).get(n - j - 1));
        a.get(i).set(n - j - 1, temp);
    }

    private static void swap(ArrayList<ArrayList<Integer>> a, int i, int j) {
        int temp = a.get(i).get(j);
        a.get(i).set(j, a.get(j).get(i));
        a.get(j).set(i, temp);
    }
}
