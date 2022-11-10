package interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given an array of candidate numbers A and a target number B, find all unique combinations in A
where the candidate numbers sums to B.
The same repeated number may be chosen from A unlimited number of times.
Note:
1) All numbers (including target) will be positive integers.
2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
3) The combinations themselves must be sorted in ascending order.
4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ...
ai = bi AND ai+1 > bi+1)
5) The solution set must not contain duplicate combinations.

Problem Constraints
1 <= |A| <= 20
1 <= A[i] <= 50
1 <= B <= 500

Input Format
The first argument is an integer array A.
The second argument is integer B.

Output Format
 Return a vector of all combinations that sum up to B.

Example Input
Input 1:
A = [2, 3]
B = 2
Input 2:
A = [2, 3, 6, 7]
B = 7

Example Output
Output 1:
[ [2] ]
Output 2:
[ [2, 2, 3] , [7] ]

Example Explanation
Explanation 1:
All possible combinations are listed.
Explanation 2:
All possible combinations are listed.
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new ArrayList<>(List.of(2, 3, 6, 7)), 7));
    }

//    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        Collections.sort(A);
//        helper(A, 0, result, new ArrayList<>(), 0, B);
//        return result;
//    }
//
//    private static void helper(ArrayList<Integer> A, int i, ArrayList<ArrayList<Integer>> result, ArrayList<Integer>
//            temp, int total, int target) {
//        if (total == target) {
//            result.add(new ArrayList<>(temp));
//            return;
//        }
//        if (i >= A.size() || total > target) {
//            return;
//        }
//        temp.add(A.get(i));
//        helper(A, i, result, temp, total + A.get(i), target);
//        temp.remove(temp.size() - 1);
//        helper(A, i+1, result, temp, total, target);
//    }



    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);
        helper(A, ans, new ArrayList<>(), B, 0);
        return new ArrayList<>(ans);
    }

    private static void helper(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, int b, int idx) {
        if (b < 0) {
            return;
        }
        if (b == 0) {
            if(!ans.contains(curr)) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = idx; i < a.size(); i++) {
            curr.add(a.get(i));
            helper(a, ans, curr, b - a.get(i), i);
            curr.remove(curr.size() - 1);
        }
    }
}