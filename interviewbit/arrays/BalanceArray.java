package interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array A of size N. You need to count the number of special elements in the given array.
 * <p>
 * A element is special if removal of that element make the array balanced.
 * <p>
 * Array will be balanced if sum of even index element equal to sum of odd index element.
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * <p>
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is an integer array A of size N.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the count of special elements.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 1, 6, 4]
 * Input 2:
 * <p>
 * A = [5, 5, 2, 5, 8]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * After deleting 1 from array : {2,6,4}
 * (2+4) = (6)
 * Hence 1 is the only special element, so count is 1
 * Explanation 2:
 * <p>
 * If we delete A[0] or A[1] , array will be balanced
 * (5+5) = (2+8)
 * So A[0] and A[1] are special elements, so count is 2.
 */
public class BalanceArray {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(5, 5, 2, 5, 8))));
        System.out.println(solve(new ArrayList<>(List.of(2, 1, 6, 4))));
    }

    public static int solve(ArrayList<Integer> A) {
        int oddSum = 0;
        int evenSum = 0;
        int ans = 0;

        // This loop forms the sum of odd and event numbers
        for (int i = 0; i < A.size(); i++) {
            if (i % 2 == 0) {
                evenSum += A.get(i);
            } else {
                oddSum += A.get(i);
            }
        }

        /**
         * Logic explanation:
         *
         * e.g. 5,5,2,5,8
         *      0,1,2,3,4
         *
         * oddSum = 5+5
         * evenSum = 5+2+8
         *
         * loop 1: i = 4
         * evenSum - 8 = 7
         * assuming removing 8, so array remains 5,5,2,5 and evenSum != oddSum
         * preparing the odd and evensum for next loop by adding 8 to oddSum such that in the next iteration where
         * array will be 5,5,2,8
         * oddSum + 8 = 18
         *
         * loop 2: i = 3
         * oddSum - 5 = 13
         * assuming removing 5, so array remains 5,5,2,8 and evenSum != oddSum
         * preparing the odd and evensum for next loop by adding 5 to evenSum such that in the next iteration where
         * array will be 5,5,5,8
         * evenSum + 5 = 12
         *
         * loop 3: i = 2
         * evenSum - 2 = 10
         * assuming removing 2, so array remains 5,5,5,8 and evenSum != oddSum
         * preparing the odd and evensum for next loop by adding 2 to oddSum such that in the next iteration where
         * array will be 5,2,5,8
         * oddSum + 2 = 15
         *
         * loop 4: i = 1
         * oddSum - 5 = 10
         * assuming removing 5, so array remains 5,2,5,8 and evenSum == oddSum, ans++ i.e. ans=1
         * preparing the odd and evensum for next loop by adding 5 to evenSum such that in the next iteration where
         * array will be 5,2,5,8
         * evenSum + 5 = 15
         *
         * loop 5: i = 0
         * evenSum - 5 = 10
         * assuming removing 5, so array remains 5,2,5,8 and evenSum == oddSum, ans++ i.e. ans=2
         * preparing the odd and evensum for next loop by adding 5 to oddSum such that in the next iteration where
         * array will be 5,2,5,8
         * oddSum + 5 = 15
         *
         */
        for (int i = A.size() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                evenSum = evenSum - A.get(i);
                if (oddSum == evenSum) {
                    ans++;
                }
                oddSum = oddSum + A.get(i);
            } else {
                oddSum = oddSum - A.get(i);
                if (oddSum == evenSum) {
                    ans++;
                }
                evenSum = evenSum + A.get(i);
            }
        }
        return ans;
    }
}
