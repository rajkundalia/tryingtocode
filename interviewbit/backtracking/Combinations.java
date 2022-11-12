package interviewbit.backtracking;

import java.util.ArrayList;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :

If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Example : itertools.combinations in python.

If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(A, B, 1, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int a, int b, int start, ArrayList<Integer> current,
                                  ArrayList<ArrayList<Integer>> result) {
        if (current.size() == b) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < a + 1; i++) {
            current.add(i);
            backtrack(a, b, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
