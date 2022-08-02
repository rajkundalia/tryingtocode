package interviewbit.binarysearch;

/*
Given a sorted array of integers, find the number of occurrences of a given target value.
Your algorithm’s runtime complexity must be in the order of O(log n).
If the target is not found in the array, return 0

**Example : **
Given [5, 7, 7, 8, 8, 10] and target value 8,
return 2.

PROBLEM APPROACH :
For complete solution, look at the hint.
 */
public class CountElementOccurence {
    public static void main(String[] args) {
        System.out.println(findCountElementOccurence(new int[]{4, 7, 7, 7, 8, 10, 10}, 3));
    }

    public static int findCountElementOccurence(final int[] A, int B) {
        int n = A.length;
        int start = 0;
        int end = n - 1;
        int firstOccurrence = firstOccurrence(A, B, start, end);
        int lastOccurrence = lastOccurrence(A, B, start, end);
        if(lastOccurrence == -1 && firstOccurrence == -1) {
            return 0;
        }
        return lastOccurrence - firstOccurrence + 1;
    }

    public static int firstOccurrence(int[] a, int b, int start, int end) {
        int res = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == b) {
                res = mid;
                end = mid - 1;
            } else if (a[mid] < b) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    public static int lastOccurrence(int[] a, int b, int start, int end) {
        int res = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == b) {
                res = mid;
                start = mid + 1;
            } else if (a[mid] < b) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
