package interviewbit.binarysearch;

import java.util.List;

/*
Suppose a sorted array A is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
The array will not contain duplicates.
NOTE 1: Also think about the case when there are duplicates.
Does your current solution work? How does the time complexity change?*
PROBLEM APPROACH:
Note: If you know the number of times the array is rotated, then this problem becomes trivial.
If the number of rotation is x, then minimum element is A[x].
Lets look at how we can calculate the number of times the array is rotated.
Complete solution in the hints.
 */
public class RotatedArray {
    public static void main(String[] args) {
        System.out.println(findMin(List.of(4, 5, 6, 7, 0, 1, 2, 3)));
    }

    public static int findMin(final List<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) > arr.get(high)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr.get(high);
    }
}
