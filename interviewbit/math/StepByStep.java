package interviewbit.math;

/*
Given a target A on an infinite number line, i.e. -infinity to +infinity.
You are currently at position 0 and you need to reach the target by moving according to the below rule:

In ith move you can take i steps forward or backward.
Find the minimum number of moves required to reach the target.

Problem Constraints
-109 <= A <= 109

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the minimum moves to reach target.

Example Input
Input 1:
 3
Input 2:
 2


Example Output
Output 1:
 2
Output 2:
 3


Example Explanation
Explanation 1:
 On the first move we step from 0 to 1.
 On the second step we step from 1 to 3.
Explanation 2:
 On the first move we step from 0 to 1.
 On the second move we step  from 1 to -1.
 On the third move we step from -1 to 2.
 */
public class StepByStep {
    public static void main(String[] args) {
        System.out.println(solveStepByStep(-35));
        System.out.println(solveStepByStepTwo(-35));
    }

    /*
        Notes: Remove x from running sum -> decreases running sum by 2x
        So, to reduce by y, remove y/2 from running sum. Thus y should be an even number.
     */
    public static int solveStepByStep(int A) {
        int i = 0;
        int runningSum = 0;
        A = Math.abs(A); // This was added for negative values
        while (runningSum < A) {
            i++;
            runningSum += i;
        }
        while ((runningSum - A) % 2 != 0) {
            i++;
            runningSum += i;
        }
        return i;
    }

    /*
        Method 2: Can be ignored, take a look at: https://youtu.be/zwYchxygB98
        Step by Step InterviewBit Math Solution Explained in Detail Tanishq Chaudhary
     */
    public static int solveStepByStepTwo(int A) {
        A = Math.abs(A); // This was added for negative values
        int i = (int) ((Math.sqrt(1 + 8 * A) - 1) / 2);
        int runningSum = i * (i + 1) / 2;

        if (runningSum < A) {
            i++;
            runningSum += i;
        }
        while ((runningSum - A) % 2 != 0) {
            i++;
            runningSum += i;
        }
        return i;
    }
}
