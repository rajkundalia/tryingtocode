package interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an array of integers A and an integer B.
Find the total number of subarrays having exactly B odd numbers.

Problem Constraints
1 <= length of the array <= 105
1 <= A[i] <= 109
0 <= B <= A

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the total number of subarrays having exactly B odd numbers.

Example Input
Input 1:
 A = [4, 3, 2, 3, 4]
 B = 2
Input 2:
 A = [5, 6, 7, 8, 9]
 B = 3

Example Output
Output 1:
 4
Output 2:
 1

Example Explanation
Explanation 1:
 The subarrays having exactly B odd numbers are:
 [4, 3, 2, 3], [4, 3, 2, 3, 4], [3, 2, 3], [3, 2, 3, 4]
Explanation 2:
 The subarrays having exactly B odd numbers is [5, 6, 7, 8, 9]
 */
public class SubArrayWithBOddNumbers {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(4, 3, 2, 3, 4)), 2));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int oddCount = 0; //For storing count of odd number till ith index
        int subArrayCount = 0; //For storing the count of subArray with B odd numbers
        //map for storing the count of arrays
        //starting from 0th index with key as odd number count
        HashMap<Integer, Integer> oddCountMap = new HashMap<>();
        oddCountMap.put(0, 1);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) % 2 != 0) {
                oddCount++;
            }
            subArrayCount += oddCountMap.getOrDefault(oddCount - B, 0);
            oddCountMap.put(oddCount, oddCountMap.getOrDefault(oddCount, 0) + 1);
        }
        return subArrayCount;
    }
}



