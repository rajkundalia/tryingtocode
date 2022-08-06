package interviewbit.binarysearch;

import java.util.Arrays;

/*
Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given
integer B in array A.

Your algorithm’s runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A
and second element = ending position of B in A, if B is not found in A return [-1, -1].

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return an array of size 2, such that first element = starting position of B in A
and second element = ending position of B in A, if B is not found in A return [-1, -1].

Constraints
1 <= N <= 10^6
1 <= A[i], B <= 10^9
For Example
Input 1:
    A = [5, 7, 7, 8, 8, 10]
    B = 8
Output 1:
    [3, 4]
Explanation 1:
    First occurence of 8 in A is at index 3
    Second occurence of 8 in A is at index 4
    ans = [3, 4]

Input 2:
    A = [5, 17, 100, 111]
    B = 3
Output 2:
    [-1, -1]
 */
public class SearchForARange {
    public static void main(String[] args) {
        int[] arr = searchRange(new int[]{4, 7, 7, 7, 8, 10, 10}, 7);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] searchRange(final int[] A, int B) {
        int n = A.length;
        int start = 0;
        int end = n - 1;
        int firstOccurrence = firstOccurrence(A, B, start, end);
        int lastOccurrence = lastOccurrence(A, B, start, end);
        return new int[]{firstOccurrence, lastOccurrence};
    }

    private static int firstOccurrence(int[] a, int b, int start, int end) {
        int res = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == b) {
                res = mid;
                end = mid - 1;
            } else if (a[mid] > b) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private static int lastOccurrence(int[] a, int b, int start, int end) {
        int res = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == b) {
                res = mid;
                start = mid + 1;
            } else if (a[mid]> b) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
