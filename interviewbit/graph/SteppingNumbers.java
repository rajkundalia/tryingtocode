package interviewbit.graph;

import java.util.ArrayList;
import java.util.Collections;

/*
Given A and B you have to find all stepping numbers in range A to B.

The stepping number:
A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g. 123 is stepping number, but 358 is not a stepping number

Problem Constraints
1 <= A <= 104
1 <= B <= 107
A <= B

Input Format
First argument is an integer A.
Second argument is an integer B.

Output Format
Return a integer array sorted in ascending order denoting the stepping numbers between A and B.

Example Input
Input 1:
 A = 10
 B = 20

Example Output
Output 1:
 [10, 12]

Example Explanation
Explanation 1:

 All stepping numbers are 10 , 12
 */
public class SteppingNumbers {
    public static void main(String[] args) {
        System.out.println(new SteppingNumbers().stepnum(10, 20));
    }

    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A <= 0 && B >= 0) {
            result.add(0);
        }
        for (int i = 1; i <= 9; i++) {
            dfs(i, A, B, result);
        }
        Collections.sort(result);
        return result;
    }

    private void dfs(int i, int A, int B, ArrayList<Integer> result) {
        if (i > B) {
            return;
        }

        int current = i % 10;

        if (i >= A && i <= B) {
            result.add(i);
        }

        if (current != 0) {
            dfs(i * 10 + (current - 1), A, B, result);
        }

        if (current != 9) {
            dfs(i * 10 + (current + 1), A, B, result);
        }
    }
}
