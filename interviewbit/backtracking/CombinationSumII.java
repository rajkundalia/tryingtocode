package interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a collection of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :
Given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
 */
//https://youtu.be/rSA3t6BDDwg
public class CombinationSumII {
    public static void main(String[] args) {
        System.out.println(combinationSum(new ArrayList<>(List.of(10, 1, 2, 7, 6, 1, 5)), 8));
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(a);
        backtrack(0, ans, new ArrayList<>(), a, b);
        return ans;
    }

    private static void backtrack(int index, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> current,
                                  ArrayList<Integer> a, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
        }
        if (target <= 0) {
            return;
        }

        int prev = - 1;
        for (int i = index; i < a.size(); i++) {
            if (a.get(i) == prev) {
                continue;
            }
            current.add(a.get(i));
            backtrack(i + 1, ans, current, a, target - a.get(i));
            current.remove(current.size() - 1);
            prev = a.get(i);
        }
    }
}
