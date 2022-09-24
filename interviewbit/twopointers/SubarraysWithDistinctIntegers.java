package interviewbit.twopointers;

import java.util.HashMap;
import java.util.Map;

/*
Given an array A of positive integers,call a (contiguous,not necessarily distinct) subarray of A good if
the number of different integers in that subarray is exactly B.
(For example: [1, 2, 3, 1, 2] has 3 different integers 1, 2 and 3)
Return the number of good subarrays of A.

Problem Constraints
1 <= |A| <= 40000
1 <= A[i] <= |A|
1 <= B <= |A|

Input Format
The first argument given is the integer array A.
The second argument given is an integer B.

Output Format
Return an integer denoting the number of good subarrays of A.

Example Input
Input 1:
 A = [1, 2, 1, 2, 3]
 B = 2
Input 2:
 A = [1, 2, 1, 3, 4]
 B = 3

Example Output
Output 1:
 7
Output 2:
 3

Example Explanation
Explanation 1:
  Subarrays formed with exactly 2 different integers: [1, 2], [2, 1], [1, 2], [2, 3], [1, 2, 1], [2, 1, 2], [1, 2, 1, 2].
Explanation 2:
  Subarrays formed with exactly 3 different integers: [1, 2, 1, 3], [2, 1, 3], [1, 3, 4].
 */
public class SubarraysWithDistinctIntegers {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 1, 2, 3}, 2));
    }

    /*
        The idea here is that if we find number of sub arrays having at most B distinct elements and then at most
        B - 1 distinct elements, subtract the count i.e. atmost(B, A) - atmost(B-1, A), gives us exact number of
        sub arrays that have exactly B distinct elements.
        https://www.youtube.com/watch?v=akwRFY2eyXs&ab_channel=CodewithAlisha
     */
    public static int solve(int[] A, int B) {
        return atmost(B, A) - atmost(B - 1, A);
    }

    private static int atmost(int B, int[] A) {
        int i = 0; // pointer that moves ahead
        int j = 0; // pointer that stays behind
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (i < A.length) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            while (map.size() > B) {
                map.put(A[j], map.get(A[j]) - 1);
                if (map.get(A[j]) <= 0) {
                    map.remove(A[j]);
                }
                j++;
            }
            count += (i - j + 1);
            i++;
        }
        return count;
    }
}

/*
// Java implementation of the approach
import java.util.*;

public class GfG {

	// Function to return the count of subarrays
	// with at most K distinct elements using
	// the sliding window technique
	private static int atMostK(int arr[], int n, int k)
	{

		// To store the result
		int count = 0;

		// Left boundary of window
		int left = 0;

		// Right boundary of window
		int right = 0;

		// Map to keep track of number of distinct
		// elements in the current window
		HashMap<Integer, Integer> map = new HashMap<>();

		// Loop to calculate the count
		while (right < n) {

			// Calculating the frequency of each
			// element in the current window
			map.put(arr[right],
					map.getOrDefault(arr[right], 0) + 1);

			// Shrinking the window from left if the
			// count of distinct elements exceeds K
			while (map.size() > k) {
				map.put(arr[left], map.get(arr[left]) - 1);
				if (map.get(arr[left]) == 0)
					map.remove(arr[left]);
				left++;
			}

			// Adding the count of subarrays with at most
			// K distinct elements in the current window
			count += right - left + 1;
			right++;
		}
		return count;
	}

	// Function to return the count of subarrays
	// with exactly K distinct elements
	private static int exactlyK(int arr[], int n, int k)
	{

		// Count of subarrays with exactly k distinct
		// elements is equal to the difference of the
		// count of subarrays with at most K distinct
		// elements and the count of subararys with
		// at most (K - 1) distinct elements
		return (atMostK(arr, n, k)
				- atMostK(arr, n, k - 1));
	}

	// Driver code
	public static void main(String[] args)
	{
		int arr[] = { 2, 1, 2, 1, 6 };
		int n = arr.length;
		int k = 2;

		System.out.print(exactlyK(arr, n, k));
	}
}
 */
