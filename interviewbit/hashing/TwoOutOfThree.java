package interviewbit.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given are Three arrays A, B and C.
Return the sorted list of numbers that are present in atleast 2 out of the 3 arrays.

Problem Constraints
1 <= |A|, |B|, |C| <= 100000
1 <= A[i], B[i], C[i] <= 100000
A, B, C may or may not have pairwise distinct elements.

Input Format
First argument is the array A.
First argument is the array B.
First argument is the array C.

Output Format
Return a sorted array of numbers.

Example Input
Input 1:
A = [1, 1, 2]
B = [2, 3]
C = [3]
Input 2:
A = [1, 2]
B = [1, 3]
C = [2, 3]

Example Output
Output 1:
[2, 3]
Output 2:
[1, 2, 3]

Example Explanation
Explanation 1:
1 is only present in A. 2 is present in A and B. 3 is present in B and C.
Explanation 2:
All numbers are present in atleast 2 out of 3 lists.
 */
public class TwoOutOfThree {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(1, 1, 2)), new ArrayList<>(List.of(2, 3)), new ArrayList<>(List.of(3))));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for (int i : A) {
            set1.add(i);
            set.add(i);
        }
        for (int i : B) {
            set2.add(i);
            set.add(i);
        }
        for (int i : C) {
            set3.add(i);
            set.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i : set) {
            if (set1.contains(i) && set2.contains(i) || set2.contains(i) && set3.contains(i)
                    || set3.contains(i) && set1.contains(i)) {
                result.add(i);
            }
        }
        Collections.sort(result)
        return result;
    }
}
