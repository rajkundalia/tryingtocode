package leetcode.topinterview150;

/*
You are given an m x n integer matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        System.out.println(new SearchA2DMatrix().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}},
                3));
    }

    /*
    Treating the Matrix as a 1-Dimensional Array
        To apply binary search, we need a one-dimensional array. We can treat our 2-D matrix as a one-dimensional
        array because of the matrix's sorted property. The first integer of each row is greater than the last integer
        of the previous row, so we can think of the rows as being appended one after the other to form a single sorted array.

    Binary Search
        Binary search is a search algorithm that finds the position of a
        target value within a sorted array. It compares the target value to the middle element of the array.
        If they are not equal, the half in which the target cannot lie is eliminated, and the search continues
        on the remaining half until it is successful or the remaining half is empty.

    Initialization
        Before we start the binary search, we need to initialize two pointers:

        left - This represents the start of the array. We set this to 0 (the index of the first element).
        right - This represents the end of the array. We set this to m * n - 1 (the index of the last element),
        where m and n are the number of rows and columns in the matrix, respectively.

    Iterative Binary Search
        We perform a binary search iteratively within a while loop until left exceeds right.
        In each iteration, we calculate the midpoint between left and right.

        To get the row and column of the midpoint in the matrix, we use the divmod function with mid and n.
        The divmod function takes two numbers and returns a pair of numbers (a tuple) consisting of their quotient and remainder.

        We then compare the value at the midpoint with the target:

        If the midpoint value is equal to the target, we have found the target in the matrix, and we return True.
        If the midpoint value is less than the target, this means the target must be in the right half of the array. So, we adjust left to be mid + 1.
        If the midpoint value is greater than the target, this means the target must be in the left half of the array. So, we adjust right to be mid - 1.
        If we exit the while loop, that means we did not find the target in the matrix, so we return False.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = (m * n) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
