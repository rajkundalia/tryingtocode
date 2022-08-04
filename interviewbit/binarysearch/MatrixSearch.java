package interviewbit.binarysearch;

/*
Given a matrix of integers A of size N x M and an integer B.
Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.

Return 1 if B is present in A, else return 0.
Note: Rows are numbered from top to bottom and columns are numbered from left to right.
Input Format

The first argument given is the integer matrix A.
The second argument given is the integer B.
Output Format
Return 1 if B is present in A, else return 0.
Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 10^6
For Example
Input 1:
    A =
    [ [1,  3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]  ]
    B = 3
Output 1:
    1
Input 2:
    A = [   [5, 17, 100, 111]
            [119, 120,  127,   131]    ]
    B = 3
Output 2:
    0
 */
public class MatrixSearch {
    public static void main(String[] args) {
        int[][] arr = {{5, 17, 100, 111},
                {119, 120, 127, 131}};
        System.out.println(searchMatrix(arr, 3));
    }

    /*
        Since the elements are in sorted order, if we go in order of: 00(0),01(1),02(2),03(3),10(4),11(5),12(6),13(7)
        it will be order. Then binary search can be applied. Numbers mentioned in bracket are virtual indices.

        Formula for conversion between virtual index and matrix index is:
        [virtualIndex/columnLength][virtualIndex%columnLength]
     */
    public static int searchMatrix(int[][] A, int B) {
        if (A.length == 0) {
            return 0;
        }
        int n = A.length;
        int m = A[0].length;

        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid / m][mid % m] == B) {
                return 1;
            } else if (A[mid / m][mid % m] > B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
