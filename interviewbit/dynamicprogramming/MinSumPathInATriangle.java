package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is

Problem Constraints
1 <= |A| <= 1000
1 <= A[i] <= 1000

Input Format
 First and only argument is the vector of vector A defining the given triangle

Output Format
 Return the minimum sum

Example Input
Input 1:
A = [
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
Input 2:
 A = [ [1] ]

Example Output
Output 1:
 11
Output 2:
 1

Example Explanation
Explanation 1:
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Explanation 2:
 Only 2 can be collected.
 */
public class MinSumPathInATriangle {
    public static void main(String[] args) {
        System.out.println(new MinSumPathInATriangle().minimumTotal(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(2)),
                        new ArrayList<>(List.of(3, 4)),
                        new ArrayList<>(List.of(6, 5, 7)),
                        new ArrayList<>(List.of(4, 1, 8, 3))
                        ))
        ));
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < a.get(i).size(); j++) {
                a.get(i).set(j, a.get(i).get(j) + Math.min(a.get(i+1).get(j), a.get(i+1).get(j+1)));
            }
        }
        return a.get(0).get(0);
    }
}
