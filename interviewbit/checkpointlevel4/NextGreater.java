package interviewbit.checkpointlevel4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Given an array, find the next greater element G[i] for every element A[i] in the array.
The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array.

More formally,

G[i] for an element A[i] = an element A[j] such that
    j is minimum possible AND
    j > i AND
    A[j] > A[i]
Elements for which no greater element exist, consider next greater element as -1.

Example:

Input : A : [4, 5, 2, 10]

Output : [5, 10, 10, -1]

Example 2:

Input : A : [3, 2, 1]

Output : [-1, -1, -1]
 */
public class NextGreater {
    public static void main(String[] args) {
        System.out.println(nextGreater(new ArrayList<>(List.of(4, 5, 2, 10))));
    }

    public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        Integer[] arr = new Integer[A.size()];
        Arrays.fill(arr, -1);
        for (int i = 0; i < A.size(); i++) {
            while (!stack.empty() && A.get(stack.peek()) < A.get(i)) {
                arr[stack.peek()] = A.get(i);
                stack.pop();
            }
            stack.push(i);
        }
        return new ArrayList<>(Arrays.asList(arr));
    }
}
