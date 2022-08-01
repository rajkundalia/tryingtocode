package interviewbit.math;

import java.util.ArrayList;
import java.util.List;

/*
You are given an integer A which represents the length of a permutation.
 A permutation is an array of length A where all the elements occur exactly once and in any order.
 For example, [3, 4, 1, 2], [1, 2, 3] are examples of valid permutations while [1, 2, 2], [2] are not.

You are also given an integer B.
 If all the permutation of length A are sorted lexicographically, return the Bth permutation.

Problem Constraints
1 <= A <= 105
1 <= B <= min(1018, A!), where A! denotes the factorial of A.

Input Format
The first argument is the integer A.
The second argument is the long integer B.

Output Format
Return an array denoting the Bth permutation of length A.

Example Input
Input 1:
A = 3
B = 3
Input 2:
A = 1
B = 1

Example Output
Output 1:
[2, 1, 3]
Output 2:
[1]

Example Explanation
Explanation 1:
All the permutations of length 3 sorted in lexicographical order are:
[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1].
Therefore, the third permutation is [2, 1, 3].
Explanation 2:
There is only one possible permutation -> [1].
 */
public class KthPermutation {
    public static void main(String[] args) {
        System.out.println(solveKthPermutation(14, 127107));
    }

    /*
        Explanation:
        Mathematically speaking there can be 4 variations while generating the permutation.
        We can have our permutation starting with either 1 or 2 or 3 or 4.
        If the first position is already occupied by one number there are three more positions left.
        The remaining three numbers can be permuted among themselves while filling the 3 positions and will
        generate 3! = 6 sequences. Hence each block will have 6 permutations adding up to a total of 6*4 = 24
        permutations. If we consider the sequences as 0-based and in the sorted form we observe:-

        The 0th – 5th permutation will start with 1
        The 6th – 11th permutation will start with 2
        The 12th – 17th permutation will start with 3
        The 18th – 23rd permutation will start with 4.

        Block No.   Number at 1st position  Remaining numbers
        0           1                          2,3,4
        1           2                          1,3,4
        2           3                          1,2,4
        3           4                          1,2,3

        We make K = 17-1 considering 0-based indexing.
        Since each of the four blocks illustrated above comprises 6 permutations, therefore,
        the 16th permutation will lie in (16 / 6 ) = 2nd block, and our answer is the (16 % 6) = 4th sequence from
        the 2nd block. Therefore 3 occupies the first position of the sequence and K = 4.

        3___

        STEP 2:

        Our new search space comprises three elements {1,2,4} where K = 4 .
        Using the previous technique we can consider the second position to be occupied can be any one of these 3 numbers.
        Again one block can start with 1, another can start with 2 and the last one can start with 4 .
        Since one position is fixed, the remaining two numbers of each block can form 2! = 2  sequences. In sorted order :

        The 0th – 1st sequence starts with 1
        The 2nd – 3rd sequence starts with 2
        The 4th – 5th sequence starts with 4

        Block No.   Number at 1st position  Remaining numbers
        0           1                          2,4
        1           2                          1,4
        2           4                          1,2

        The 4th permutation will lie in (4/2) = 2nd block and our answer is the 4%2 = 0th sequence from the 2nd block.
        Therefore 4 occupies the second position and K = 0.

        34__

        STEP 3:
        The new search space will have two elements {1 ,2} and K = 0.
        One block starts with 1 and the other block starts with 2.
        The other remaining number can form only one 1! = 1 sequence. In sorted form –

        The  0th sequence starts with 1
        The  1st sequence. starts with 2

        Block No.   Number at 1st position  Remaining numbers
        0           1                          2
        1           2                          1

        The 0th permutation will lie in the (0/1) = 0th block and our answer is the 0%1 = 0th sequence from the 0th block.
        Therefore 1 occupies the 3rd position and K = 0.

        341_

        STEP 4:

        Now the only block has 2 in the first position and no remaining number is present.
        Block No.   Number at 1st position  Remaining numbers
        0           2                       {}

        3412

        Final answer is 3412






     */
    public static ArrayList<Integer> solveKthPermutation(int A, long B) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < A; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(A);
        int b = (int) (B - 1);
        ArrayList<Integer> ans = new ArrayList<>();
        while (true) {
            ans.add(numbers.get(b / fact));
            numbers.remove(b / fact);
            if (numbers.isEmpty()) {
                break;
            }
            b = b % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }

}
