package interviewbit.greedyalgorithm;

import java.util.Arrays;

/*
N children are standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum number of candies you must give?

Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109

Input Format
The first and only argument is an integer array A representing the rating of children.

Output Format
Return an integer representing the minimum candies to be given.

Example Input
Input 1:
 A = [1, 2]
Input 2:
 A = [1, 5, 2, 1]

Example Output
Output 1:
 3
Output 2:
 7

Example Explanation
Explanation 1:
 The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
 So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
Explanation 2:
 Candies given = [1, 3, 2, 1]
 */
public class DistributeCandy {
    public static void main(String[] args) {
        System.out.println(new DistributeCandy().candy(new int[]{1, 5, 2, 1}));
    }

    //https://youtu.be/PzBYQA6FshA
    public int candy(int[] A) {
        int n = A.length;
        int[] left = new int[n + 1];
        Arrays.fill(left, 1);

        for (int i = 1; i < A.length; i++) {
            /*
                1 2 3
                1 1 1
                left 1 2 3
             */
            if (A[i] > A[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int right = 1;

        for (int j = n - 2; j >= 0; j--) {
            if (A[j] > A[j + 1]) {
                right++;
                left[j] = Math.max(left[j], right);
            } else {
                right = 1;
            }
        }


        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += left[j];
        }
        return sum;
    }
}
