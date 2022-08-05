package interviewbit.binarysearch;

/*
Given a matrix of integers A of size N x M in which each row is sorted.
Find and return the overall median of the matrix A.
Note: No extra memory is allowed.
Note: Rows are numbered from top to bottom and columns are numbered from left to right.

Input Format
The first and only argument given is the integer matrix A.

Output Format
Return the overall median of the matrix A

Constraints
1 <= N, M <= 10^5
1 <= N*M  <= 10^6
1 <= A[i] <= 10^9
N*M is odd
For Example
Input 1:
    A = [   [1, 3, 5],
            [2, 6, 9],
            [3, 6, 9]   ]
Output 1:
    5
Explanation 1:
    A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
    Median is 5. So, we return 5.
Input 2:
    A = [   [5, 17, 100]    ]
Output 2:
    17
 */
public class MatrixMedian {
    public static void main(String[] args) {
        int[][] arr = {{2, 3, 5},
                {2, 3, 4},
                {1, 7, 9}};
        System.out.println(findMedian(arr));
    }

    /*
        Step 1: Find the minimum and maximum element in the given array. By just traversing the first column,
        we find the minimum element and by just traversing the last column, we find the maximum element.

        Step 2: Now find the middle element of the array one by one and check in the matrix how many elements are
        present in the matrix.

        Three cases can occur:-

        If count ==  (r*c+1)/2 , so it may be the answer still we mark max as mid since we are not referring indices ,
        we are referring the elements and 5 elements can be smaller than 6 also and 7 also,
        so to confirm we mark max as mid.
        If count<(r*c+1)/2 , we mark  min as mid+1 since curr element or elements before it cannot be the answer.
        If count>(r*c+1)/2 , we mark max as mid , since elements after this can only be the  answer now.
        Let’s discuss the approach with an example

        For eg, the given array is:

        [[2,3,5],
         [2,3,4],
         [1,7,9]]
         1,2,2,3,3,4,5,7,9
        As per step 1: min = 1, max = 9 and mid is 5.
        Number of elements smaller than equal to 5 are 1,2,2,3,3,4,5 which are 7 in count
        Since 7>5, max = 5 (mid).

        As per step 2: mid of min=1 and max = 5 is 3.
        Number of elements smaller than equal to 3 are 1,2,2,3,3 which are 5 in count
        Since 5=5, max = 3 (mid).

        As per step 3: mid of min = 1 and max = 3 is 2
        Number of elements smaller than equal to 2 are 1,2,2 which are 3 in count
        Since 3<5, max = 3 (2+1).

        Since min = max, we return min = 3 as the answer.
     */

    public static int findMedian(int[][] A) {
        int low = 1;
        int high = 9; // for code submission, use 1000000000
        int n = A.length;
        int m = A[0].length;

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += countSmallerThanOrEqualToMid(A[i], mid);
            }
            if (count <= (n * m) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countSmallerThanOrEqualToMid(int[] A, int mid) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int midd = (low + high) / 2;
            if (A[midd] <= mid) {
                low = midd + 1;
            } else {
                high = midd - 1;
            }
        }
        return low;
    }
}
