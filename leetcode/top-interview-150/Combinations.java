package leetcode.topinterview150;

import java.util.LinkedList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 */
public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }

    // https://youtu.be/uvk_HvqCQNc?si=GgeUcguwoY_pCDSJ
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (k == 0) {
            result.add(new LinkedList<>());
            return result;
        }
        backtrack(1, new LinkedList<>(), n, k, result);
        return result;
    }

    public void backtrack(int start, LinkedList<Integer> current, int n, int k, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new LinkedList<>(current));
        }

        for (int i = start; i <= n && current.size() < k; i++) {
            current.add(i);
            backtrack(i + 1, current, n, k, result);
            current.removeLast();
        }
    }
}
