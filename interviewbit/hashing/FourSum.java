package interviewbit.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note:

Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
Example :

Given array S = {1 0 -1 0 -2 2}, and target = 0

A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
Also make sure that the solution set is lexicographically sorted.

Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR
(Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
 */
public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new ArrayList<>(List.of(1, 0, -1, 0, -2, 2)), 0));
    }

    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Collections.sort(A);

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int k = j + 1;
                int l = A.size() - 1;

                while (k < l) {
                    int sum = A.get(i) + A.get(j) + A.get(k) + A.get(l);
                    if (sum > B) {
                        l--;
                    } else if (sum < B) {
                        k++;
                    } else if (sum == B) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(A.get(i));
                        list.add(A.get(j));
                        list.add(A.get(k));
                        list.add(A.get(l));
                        if (!set.contains(list)) {
                            set.add(list);
                            ans.add(list);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}
