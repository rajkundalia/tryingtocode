package interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example:
 * for this problem, following are some good questions to ask :
 * <p>
 * Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 * <p>
 * Input Format
 * First argument is an array of digits.
 * <p>
 * Output Format
 * Return the array of digits after adding one.
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * [1, 2, 3]
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 4]
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Given vector is [1, 2, 3].
 * The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */
public class AddOneToNumber {
    public static void main(String[] args) {
        System.out.println(solveAddOneToNumber(new ArrayList<>(List.of(0, 1, 2, 9))));
    }

    public static ArrayList<Integer> solveAddOneToNumber(ArrayList<Integer> A) {
        for (int i = 0; i < A.size() - 1 && A.get(i) == 0;) {
            A.remove(i);
        }
        int carry = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            int temp = A.get(i) + carry;
            if (temp > 9) {
                A.set(i, temp % 10);
                carry = 1;
            } else {
                A.set(i, temp);
                carry = 0;
                break;
            }
        }
        if (carry > 0) {
            A.add(0, carry);
        }
        return A;
    }
}
