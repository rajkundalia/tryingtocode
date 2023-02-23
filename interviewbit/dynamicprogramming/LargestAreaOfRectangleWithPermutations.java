package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a binary grid A of size N x M consisting of 0's and 1's, find the area of the largest rectangle inside the
grid such that all the cells inside the chosen rectangle should have 1 in them.

You are allowed to permutate the columns matrix i.e. you can arrange each of the column in any order in the final grid.

Please follow the sample input and explanation for more clarity.

Problem Constraints
1 <= N, M <= 103

Input Format
First and only argument is an 2D binary array A.

Output Format
Return a single integer denoting the area of the largest rectangle inside the grid such that all the cells
inside the chosen rectangle should have 1 in them.

Example Input
Input 1:
 A = [  [1, 0, 1]
        [0, 1 ,0]
        [1, 0, 0]
    ]

Example Output
Output 1:
 2

Example Explanation
Explanation 1:
    1 0 1
    0 1 0
    1 0 0

At present we can see that max rectangle satisfying the criteria mentioned in the problem
 is of 1 * 1 = 1 area i.e either of the 4 cells which contain 1 in it.

Now since we are allowed to permutate the columns of the given matrix, we can take column 1
 and column 3 and make them neighbours. One of the possible configuration of the grid can be:
 1 1 0
 0 0 1
 1 0 0

Now In this grid, first column is column 1, second column is column 3 and third column
 is column 2 from the original given grid.

Now, we can see that if we calculate the max area rectangle, we get max area as 1 * 2 = 2
 which is bigger than the earlier case. Hence 2 will be the answer in this case.
 */
public class LargestAreaOfRectangleWithPermutations {
    public static void main(String[] args) {
        System.out.println(new LargestAreaOfRectangleWithPermutations().solve(new ArrayList<>(
                List.of(new ArrayList<>(List.of(1, 0, 1)), new ArrayList<>(List.of(0, 1, 0)),
                        new ArrayList<>(List.of(1, 0, 0)))
        )));
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        // add column height
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if (i != 0 && A.get(i).get(j) != 0) {
                    A.get(i).set(j, A.get(i).get(j) + A.get(i - 1).get(j));
                }
            }
        }

        // sort every row
        for (int i = 0; i < A.size(); i++) {
            Collections.sort(A.get(i));
        }

        // final area calculate
        int maxArea = 0, area = 0;
        for (int i = 0; i < A.size(); i++) {
            int width = 1;
            for (int j = A.get(0).size() - 1; j >= 0; j--) {
                area = A.get(i).get(j) * width;
                width++;
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }
}
