package interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a set of distinct integers, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.

The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.

The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
 */
public class Subset {
    public static void main(String[] args) {
        System.out.println(subsets(new ArrayList<>(List.of(1, 2))));
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        backtrack(result, new ArrayList<>(), A, 0);
        return result;
    }

    private static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, ArrayList<Integer> A,
                                  int start) {
        // Add the set to result set
        result.add(new ArrayList<>(temp));

        for (int i = start; i < A.size(); i++) {
            // case of including the number
            temp.add(A.get(i));
            // Backtrack the new subset
            backtrack(result, temp, A, i + 1);
            // Case of not-including the number
            temp.remove(temp.size() - 1);
        }
    }
}
