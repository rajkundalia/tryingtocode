package interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Example :

If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]
 */
public class SubsetsII {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new ArrayList<>(List.of(1, 2, 2))));
    }

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        backtrack(result, new ArrayList<>(), A, 0);
        return result;
    }

    private static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, ArrayList<Integer> A,
                                  int index) {
        // Add the set to result set
        result.add(new ArrayList<>(temp));
        if (index >= A.size()) {
            return;
        }

        for (int i = index; i < A.size(); i++) {
            if (i > index && A.get(i).equals(A.get(i - 1))) {
                continue;
            }
            // case of including the number
            temp.add(A.get(i));
            // Backtrack the new subset
            backtrack(result, temp, A, i + 1);
            // Case of not-including the number
            temp.remove(temp.size() - 1);
        }
    }
}
