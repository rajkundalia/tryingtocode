package interviewbit.dynamicprogramming;

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Return an integer corresponding to the maximum product possible.

Example :

Input : [2, 3, -2, 4]
Return : 6

Possible with [2, 3]
 */
public class MaxProductSubarray {
    public static void main(String[] args) {
        System.out.println(new MaxProductSubarray().maxProduct(new int[]{2, 3, -2, 4}));
    }

    /*
        A better solution will be to maintain two variables to store the maximum and minimum product
        ending in the current position. Then traverse the array once, and for every index i in the array,
        update the maximum and minimum product ending at A[i]. Update the result if the maximum product
        ending at any index is more than the maximum product found so far.
     */
    public int maxProduct(final int[] A) {
        if (A.length == 0) {
            return 0;
        }

        // maintain two variables to store the maximum and minimum product
        // ending at the current index
        int max_ending = A[0], min_ending = A[0];

        // to store the maximum product subarray found so far
        int max_so_far = A[0];

        // traverse the given array
        for (int i = 1; i < A.length; i++) {
            int temp = max_ending;

            // update the maximum product ending at the current index
            max_ending = Math.max(A[i], Math.max(A[i] * max_ending,
                    A[i] * min_ending));

            // update the minimum product ending at the current index
            min_ending = Math.min(A[i], Math.min(A[i] * temp,
                    A[i] * min_ending));

            max_so_far = Math.max(max_so_far, max_ending);
        }

        // return maximum product
        return max_so_far;
    }
}
