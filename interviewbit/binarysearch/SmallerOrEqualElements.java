package interviewbit.binarysearch;

/*
Given an sorted array A of size N. Find number of elements which are less than or equal to B.
NOTE: Expected Time Complexity O(log N)

Problem Constraints
1 <= N <= 106
1 <= A[i], B <= 109

Input Format
First agument is an integer array A of size N.
Second argument is an integer B.

Output Format
Return an integer denoting the number of elements which are less than or equal to B.

Example Input
Input 1:
 A = [1, 3, 4, 4, 6]
 B = 4
Input 2:
 A = [1, 2, 5, 5]
 B = 3

Example Output
Output 1:
 4
Output 2:
 2

Example Explanation
Explanation 1:
 Elements (1, 3, 4, 4) are less than or equal to 4.
Explanation 2:
 Elements (1, 2) are less than or equal to 3.
 */
public class SmallerOrEqualElements {
    public static void main(String[] args) {
        System.out.println(findSmallerOrEqualElements(new int[]{1, 2, 3, 5, 6}, 3));
    }

    public static int findSmallerOrEqualElements(int[] A, int B) {
        int n = A.length;
        int low = 0;
        int high = A.length - 1;
        int count = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == B) {
                count = mid + 1;
                int index = mid + 1;
                // This while loop is for repetition of numbers in the sorted array
                while (index < n && A[index] == B) {
                    count++;
                    index++;
                }
                return count;
            } else if (A[mid] > B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}