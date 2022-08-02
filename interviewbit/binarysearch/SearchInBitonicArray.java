package interviewbit.binarysearch;

/*
Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in
O(logN) time.
NOTE:
A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

Problem Constraints
3 <= N <= 105
1 <= A[i], B <= 108
Given array always contain a bitonic point.
Array A always contain distinct elements.

Input Format
First argument is an integer array A denoting the bitonic sequence.
Second argument is an integer B.

Output Format
Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.

Example Input
Input 1:
 A = [3, 9, 10, 20, 17, 5, 1]
 B = 20
Input 2:
 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 B = 30

Example Output
Output 1:
 3
Output 2:
 -1

Example Explanation
Explanation 1:
 B = 20 present in A at index 3
Explanation 2:
 B = 30 is not present in A
 */
public class SearchInBitonicArray {
    public static void main(String[] args) {
        System.out.println(searchInBitonicArray(new int[]{3, 9, 10, 20, 17, 5, 1}, 20));
    }

    static int ans = -1;

    public static int searchInBitonicArray(int[] arr, int B) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int highIndex = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // To find the max, what we need to see in bitonic array is that arr[mid]>arr[mid-1] and arr[mid]>arr[mid+1]
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                highIndex = mid;
                break;
            }

            // if order is in ascending till mid i.e. on left side, we update low to mid+1
            if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // After finding the highIndex, we should do binary search on the left side as ascending order
        // and right side of highIndex in descending order
        bS(arr, B, 0, highIndex, 'a');
        // since it is descending order from the highIndex, that is why the starting point ins highIndex
        bS(arr, B, highIndex, n - 1, 'd');
        return ans;
    }

    private static void bS(int[] arr, int b, int low, int high, char d) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == b) {
                ans = mid;
                return;
            }
            if (arr[mid] > b) {
                if (d == 'a') {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (d == 'a') {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
    }
}
