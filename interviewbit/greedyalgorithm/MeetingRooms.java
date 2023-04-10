package interviewbit.greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an 2D integer array A of size N x 2 denoting time intervals of different meetings.
Where:

A[i][0] = start time of the ith meeting.
A[i][1] = end time of the ith meeting.

Find the minimum number of conference rooms required so that all meetings can be done.
Note :- If a meeting ends at time t, another meeting starting at time t can use the same conference room

Problem Constraints
1 <= N <= 105

0 <= A[i][0] < A[i][1] <= 2 * 109

Input Format
The only argument given is the matrix A.

Output Format
Return the minimum number of conference rooms required so that all meetings can be done.

Example Input
Input 1:
 A = [      [0, 30]
            [5, 10]
            [15, 20]
     ]

Input 2:
 A =  [     [1, 18]
            [18, 23]
            [15, 29]
            [4, 15]
            [2, 11]
            [5, 13]
      ]

Example Output
Output 1:
 2
Output 2:
 4

Example Explanation
Explanation 1:
 Meeting one can be done in conference room 1 form 0 - 30.
 Meeting two can be done in conference room 2 form 5 - 10.
 Meeting three can be done in conference room 2 form 15 - 20 as it is free in this interval.
Explanation 2:
 Meeting one can be done in conference room 1 from 1 - 18.
 Meeting five can be done in conference room 2 from 2 - 11.
 Meeting four can be done in conference room 3 from 4 - 15.
 Meeting six can be done in conference room 4 from 5 - 13.
 Meeting three can be done in conference room 2 from 15 - 29 as it is free in this interval.
 Meeting two can be done in conference room 4 from 18 - 23 as it is free in this interval.
 */
public class MeetingRooms {
    public static void main(String[] args) {
        System.out.println(new MeetingRooms().solve(new int[][]{
                {1, 18},
                {18, 23},
                {15, 29},
                {4, 15},
                {2, 11},
                {5, 13}
        }));
    }

    public int solve(int[][] arr) {
        int[] startTimes = new int[arr.length];
        int[] endTimes = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            startTimes[i] = arr[i][0];
            endTimes[i] = arr[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int i = 0, j = 0, count = 0, maxCount = 0;
        while (i < arr.length && j < arr.length) {
            if (startTimes[i] < endTimes[j]) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    public int solve_1(int[][] A) {
        if (A.length == 0 && A[0].length == 0) {
            return 0;
        }

        Arrays.sort(A, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        priorityQueue.add(A[0]);

        for (int i = 1; i < A.length; i++) {
            int[] current = A[i];
            int[] previous = priorityQueue.poll();

            if (current[0] < previous[1]) {
                priorityQueue.add(previous);
                priorityQueue.add(current);
            } else {
                previous[1] = current[1];
                priorityQueue.add(previous);
            }
        }
        return priorityQueue.size();
    }
}