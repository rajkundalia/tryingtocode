package interviewbit.greedyalgorithm;

/*
N light bulbs are connected by a wire.

Each bulb has a switch associated with it, however due to faulty wiring,
a switch also changes the state of all the bulbs to the right of current bulb.

Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
You can press the same switch multiple times.
Note : 0 represents the bulb is off and 1 represents the bulb is on.

Problem Constraints
0 <= N <= 5e5
0 <= A[i] <= 1

Input Format
The first and the only argument contains an integer array A, of size N.

Output Format
Return an integer representing the minimum number of switches required.

Example Input
A = [0 1 0 1]

Example Output
4

Example Explanation
press switch 0 : [1 0 1 0]
press switch 1 : [1 1 0 1]
press switch 2 : [1 1 1 0]
press switch 3 : [1 1 1 1]
 */
public class Bulbs {
    public static void main(String[] args) {
        System.out.println(new Bulbs().bulbs(new int[]{0, 1, 0, 1}));
    }

    // https://youtu.be/IhpnenCA2TA
    // https://chaudhary1337.com/bulbs-interviewbit-solution-explained/
    public int bulbs(int[] A) {
        int cost = 0;
        for (int b : A) {
            if (cost % 2 != 0) {
                b = b == 0 ? 1 : 0;
            }

            if (b != 1) {
                cost += 1;
            }

        }
        return cost;
    }

//    public int bulbs(int[] A) {
//        int cost = 0;
//        for (int b : A) {
//            if (cost % 2 == 0) {
//                b = b;
//            } else {
//                b = b == 0 ? 1 : 0;
//            }
//
//            if (b == 1) {
//                continue;
//            } else {
//                cost += 1;
//            }
//
//        }
//        return cost;
//    }
}
