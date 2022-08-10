package interviewbit.binarysearch;

/*
Given an array of integers A of size N and an integer B.
College library has N bags,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that maximum number of pages allotted to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return that minimum possible number

Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^5
For Example
Input 1:
    A = [12, 34, 67, 90]
    B = 2
Output 1:
    113
Explanation 1:
    There are 2 number of students. Books can be distributed in following fashion :
        1) [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
        3) [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
        Here comparison is done with 191, 157 and 113.
        Of the 3 cases, Option 3 has the minimum pages = 113.

Input 2:
    A = [5, 17, 100, 11]
    B = 4
Output 2:
    100
 */
public class AllocateBooks {
    public static void main(String[] args) {
        System.out.println(books(new int[]{12, 34, 67, 90}, 2));
    }

    public static int books(int[] A, int B) {
        if (B > A.length) {
            return -1;
        }
        int low = A[0];
        int high = 0;
        // find the low and high (this is the sum)
        for (int i = 0; i < A.length; i++) {
            high += A[i];
            low = Math.min(low, A[i]);
        }
        int res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // we check if this is mid is feasible
            if (isPossible(A, mid, B)) {
                res = mid; // the idea here is to find the most minimum element, hence the assignment heere
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private static boolean isPossible(int[] a, int pages, int b) {
        int count = 0;
        int sumAllocated = 0;
        for (int i = 0; i < a.length; i++) {
            if (sumAllocated + a[i] > pages) {
                count++; // increasing the students if sum allocated to a student is greater than pages which is equivalent to mid
                sumAllocated = a[i];
                if (sumAllocated > pages) {
                    return false;
                }
            } else {
                sumAllocated += a[i];
            }
        }
        if (count < b) {
            return true;
        }
        return false;
    }
}
