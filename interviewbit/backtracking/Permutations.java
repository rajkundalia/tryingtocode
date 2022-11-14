package interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
NOTE

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new ArrayList<>(List.of(1, 2, 3))));
    }

    /*  1st               Next
        1 2 3          -> swap  1 3 2
        swap -> 2 1 3  -> swap  2 3 1
        swap -> 3 2 1  -> swap  3 1 2
     */
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        permute(ans, A, 0);
        return ans;
    }

    private static void permute(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> a, int i) {
        if (i >= a.size()) {
            ans.add(new ArrayList<>(a));
            return;
        }
        for (int j = i; j < a.size(); j++) {
            Collections.swap(a, j, i);
            permute(ans, a, i + 1);
            Collections.swap(a, j, i);
        }
    }
}
