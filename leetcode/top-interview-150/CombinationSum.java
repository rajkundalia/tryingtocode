package leetcode.topinterview150;

import java.util.LinkedList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of
candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150
combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []

 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    List<List<Integer>> resultList = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getTargetCombination(candidates, 0, target, new LinkedList<>());
        return resultList;
    }

    private void getTargetCombination(int[] candidates, int position, int currentTarget, LinkedList<Integer> result) {
        /**
         * Base case
         * 1. If currentTarget is reaching to Zero
         * 2. Current Position is equal to the length of the Array
         */
        if (currentTarget == 0) {
            resultList.add(new LinkedList<>(result));
            return;
        }
        if (position == candidates.length) {
            return;
        }

        /**
         * There are two cases
         * 1. Pick the current value if the current value (i.e arr[position]) is less than or equal to the currentTarget
         *    value then use the same attribute by passing the same position
         *
         *  2. Not picking up the current element by not reducing the currentTarget value and increasing the position
         */

        if(candidates[position] <= currentTarget) {
            result.add(candidates[position]);
            getTargetCombination(candidates, position, currentTarget - candidates[position], result);
            // removing the last element because post adding of the value the call came back
            result.removeLast();
        }
        // not picked
        getTargetCombination(candidates, position + 1, currentTarget, result);
    }
}
