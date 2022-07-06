package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers
for a given array A of size N. If such arrangement is not possible, it must be rearranged as the lowest
possible order i.e., sorted in ascending order.

Note:
1. The replacement must be in-place, do **not** allocate extra memory.
2. DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
Input Format:

The first and the only argument of input has an array of integers, A.
Output Format:

Return an array of integers, representing the next permutation of the given array.
Constraints:

1 <= N <= 5e5
1 <= A[i] <= 1e9
Examples:
Input 1:
    A = [1, 2, 3]
Output 1:
    [1, 3, 2]

Input 2:
    A = [3, 2, 1]
Output 2:
    [1, 2, 3]

Input 3:
    A = [1, 1, 5]
Output 3:
    [1, 5, 1]

Input 4:
    A = [20, 50, 113]
Output 4:
    [20, 113, 50]
 */
//2.21 NEXT PERMUTATION (Arrays)-Interviewbit bhaicodekaro: https://youtu.be/sCCRFjFJv38
public class NextPermutation {
    public static void main(String[] args) {
        System.out.println(solveNextPermutation(new ArrayList<>(List.of(1, 3, 4, 2))));
    }

    public static ArrayList<Integer> solveNextPermutation(ArrayList<Integer> a) {
        int index = -1;
        int n = a.size();

        // step 1: find the element smaller than the last element in the list in a loop
        // e.g. 1 3 4 2, so index = 1
        // meaning: the element that breaks increasing order starting from the last element
        // e.g. 1 2 4 3 -> 3>4 but then 2<4 so it breaks the increasing order from the end
        for (int i = n - 2; i >= 0; i--) {
            if (a.get(i) < a.get(i + 1)) {
                index = i;
                break;
            }
        }
        int x = 0;
        int y = n - 1;
        // step 2: reversing the whole list if there is all elements are in descending order
        if (index == -1) {
            while (x < y) {
                swap(a, x, y);
                x++;
                y--;
            }
            return a;
        }

        // step 3: From index + 1 till the end, we first find the element with the smallest
        // difference with element at index and then swap them
        int minDiff = Integer.MAX_VALUE;
        int minDiffIndex = -1;
        for (int i = index + 1; i < n; i++) {
            if (a.get(i) > a.get(index) && a.get(i) - a.get(index) < minDiff) {
                minDiff = a.get(i) - a.get(index);
                minDiffIndex = i;
            }
        }
        swap(a, index, minDiffIndex);

        // step 4: now we need to reverse the elements from the index + 1 so that number would not become large
        // this is essentially making it as ascending order of elements from index + 1
        x = index + 1;
        y = n - 1;
        while (x < y) {
            swap(a, x, y);
            x++;
            y--;
        }
        return a;
    }

    private static void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }
}
