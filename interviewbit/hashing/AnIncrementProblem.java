package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a stream of numbers A. On arrival of each number,
you need to increase its first occurrence by 1 and include this in the stream.

Return the final stream of numbers.
Note: You will traverse the stream from left to right and update the first occurrence of the number by 1, if found.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10000

Input Format
First and only argument is the array A.

Output Format
Return an array, the final stream of numbers.

Example Input
Input 1:
A = [1, 1]
Input 2:
A = [1, 2]
Input 3:
A = [1, 1, 2, 2]
Example Output
Output 1:
[2, 1]
Output 2:
[1, 2]
Output 3:
[3, 1, 3, 2]

Example Explanation
Explanation 1:
On arrival of the second element, the other element is increased by 1.

Explanation 2:
No increases are to be done.

Explanation 3:
Stream after arrival of numbers (1-based indexing):
  First number  (1): [1]          , Simply push 1 to the stream
  Second number (1): [2, 1]       , Increment first occurence of 1, present at 1st Index and push 1 to the stream
  Third number  (2): [3, 1, 2]    , Increment first occurence of 2, present at 1st Index and push 2 to the stream
  Fourth number (2): [3, 1, 3, 2] , Increment first occurence of 2, present at 3rd Index and push 2 to the stream
 */
public class AnIncrementProblem {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(1, 1, 2, 2))));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        for (int i = 0; i < A.size(); i++) {
            int index = A.indexOf(A.get(i));
            if (index >= 0 && index < i) {
                A.set(index, A.get(i) + 1);
            }
        }
        return A;
    }
}




