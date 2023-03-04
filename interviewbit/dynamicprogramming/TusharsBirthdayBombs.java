package interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
It’s Tushar’s birthday today and he has N friends.

Friends are numbered [0, 1, 2, ...., N-1] and ith friend have a positive strength B[i].

Today being his birthday, his friends have planned to give him birthday bombs (kicks).

Tushar's friends know Tushar's pain bearing limit and would hit accordingly.

If Tushar’s resistance is denoted by A (>=0) then find the lexicographically smallest order of
friends to kick Tushar so that the cumulative kick strength (sum of the strengths of friends who kicks)
doesn’t exceed his resistance capacity and total no. of kicks hit are maximum.

Also note that each friend can kick an unlimited number of times (If a friend hits x times, his strength will be counted x times)

Return the lexicographically smallest array of maximum length where the ith index represents the index of the friend who will hit.

NOTE:
[a1, a2, ...., am] is lexicographically smaller than [b1, b2, .., bm] if a1 < b1 or (a1 = b1 and a2 < b2) ... .
Input cases are such that the length of the answer does not exceed 100000.

Problem Constraints
1 <= N <= 100
1 <= A <= 15 * 106
1 <= B[i] <= 105

Input Format
The first argument contains an integer, A of length N.
The second argument contains an array of integers B.

Output Format
Return an array of integer, as described in the problem statement.

Example Input
Input 1:
 A = 12
 B = [3, 4]
Input 2:
 A = 11
 B = [6, 8, 5, 4, 7]

Example Output
Output 1:
 [0, 0, 0, 0]
Output 2:
 [0, 2]

Example Explanation
Explanation 1:
The first friend with the index value 0 and strength 3 can hit 4 times,
providing the lexicographically smallest array of maximum length
Explanation 1:
The first friend with the index value 0 and strength 6 can only hit once,
making the Tushar's resistance to 5, now the third friend with the index value 2 can hit once,
providing the lexicographically smallest array of maximum length.
 */
public class TusharsBirthdayBombs {

    class Pair {
        int index;
        int strength;

        Pair(int index, int strength) {
            this.index = index;
            this.strength = strength;
        }
    }

    /*
    Observations:

        Let the index of friend with minimum strength be F. (Take smallest index in case of a tie)

        It is obvious that -> Maximum no. of kicks = R/(S[F]).

        This is the length of the answer but since we need lexicographically smaller order (according to index),
        friends whose index is less than the F can also hit provided they do not change the length of the answer.
        There is also a crucial observation here, we need not consider the friend which have a friend to their
        left (lesser index) and have lesser than or equal strength than him.
        (Otherwise we can just take that friend with lesser index instead).

        Below is an example to clear the things out:

        R = 11, S = [6, 8, 5, 4, 7]

        In this case: Max no. of kicks = 11/4 = 2.

        answer = [3,3] (if we do not consider the lexicographic order)

        But answer may be [0,3] or [0,2] or [2,3] as they also have the same length.

        Here, only required friends to consider are newS = [6,5,4] as we will rather choose friend with strength
        6 than choosing a friend with strength 8, and rather choose any of [6,5,4] than choosing friend with strength 7.
        (Give it a thought, it's true because our answer should be lexicographically smallest)

        Note that the friend with the minimum strength will be the last element of our newS vector
        (as newS will be in strict decreasing order)

    Algorithm:

        1. Find the max no. of kicks (length of our answer).
        2. Make a new S vector which only takes the friends that can be in the answer.
        3. Iterate through the S vector formed above and see if the friend at consideration can be used instead
           of the friend with minimum strength.
        4. If he can be successfully used then use him instead of the friend with minimum strength to get a
           lexicographically smaller answer.
     */
    public static void main(String[] args) {
        //System.out.println(new TusharsBirthdayBombs().solve(12, new ArrayList<>(List.of(3, 4))));
        System.out.println(new TusharsBirthdayBombs().solve(11, new ArrayList<>(List.of(6, 8, 5, 4, 7))));
    }

    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        // newB -> only those strengths which are useful
        ArrayList<Pair> newB = new ArrayList<>();

        int previous = Integer.MAX_VALUE;

        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) < previous) {
                newB.add(new Pair(i, B.get(i)));
                previous = B.get(i);
            }
        }

        int n = newB.size();
        ArrayList<Integer> ans = new ArrayList<>();
        int R = A;
        int temp = newB.get(n - 1).strength;   //smallest strength
        int i = 0;

        while (i < n) {
            // check if the current person can hit and if he can hit
            // would he change the answer or not
            if (R >= newB.get(i).strength && (1 + (R - newB.get(i).strength) / temp) == R / temp) {
                ans.add(newB.get(i).index);
                R -= newB.get(i).strength;
            } else {
                i++;
            }
        }
        return ans;
    }
}


