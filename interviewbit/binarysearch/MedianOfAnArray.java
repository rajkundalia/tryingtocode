package interviewbit.binarysearch;

import java.util.List;

/*
There are two sorted arrays A and B of size m and n respectively.
Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
The overall run time complexity should be O(log (m+n)).
Sample Input
A : [1 4 5]
B : [2 3]

Sample Output
3
NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5
 */
public class MedianOfAnArray {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(List.of(1, 4, 5), List.of(2, 3)));
    }

    /*
        We will do a binary search in one of the arrays which have a minimum size among the two.

        Firstly, calculate the median position with (n+1)/2. Point two-pointer, say low and high, equal to 0 and size
        of the array on which we are applying binary search respectively. Find the partition of the array.

        Check if the left half has a total number of elements equal to the median position.

        If not, get the remaining elements from the second array. Now, check if partitioning is valid.

        This is only when l1<=r2 and l2<=r1. If valid, return max(l1,l2)(when odd number of elements present)
        else return (max(l1,l2)+min(r1,r2))/2.

        If partitioning is not valid, move ranges. When l1>r2, move left and perform the above operations again.
        When l2>r2, move right and perform the above operations.

        https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/

     */
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int m = a.size();
        int n = b.size();

        if (m > n) {
            findMedianSortedArrays(b, a); //ensuring that binary search happens on minimum size array
        }

        int low = 0;
        int high = m;
        int medianPosition = ((m + n) + 1) / 2;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = medianPosition - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a.get(cut1 - 1);
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b.get(cut2 - 1);
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : a.get(cut1);
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : b.get(cut2);

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 != 0) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}
