package interviewbit.math;

/*
https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/
  Given a set of digits (A) in sorted order, find how many numbers of length B are possible
  whose value is less than number C.
NOTE: All numbers can only have digits from the given set.
Examples:
Input:
  0 1 5
  1
  2
Output:
  2 (0 and 1 are possible)
Input:
  0 1 2 5
  2
  21
Output:
  5 (10, 11, 12, 15, 20 are possible)
Constraints:
1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9
 */
public class NumbersOfLengthNAndValueLessThanK {
    public static void main(String[] args) {
        System.out.println(solveNumbersOfLengthNAndValueLessThanK(new int[]{0, 1, 2, 5}, 2, 21));
    }

    /*
        case 1:
        B > number of digits in C -> No solution
        A={1,2,3,4}
        B = 4
        C = 32
        Smallest 4-digit number is 1000 which is greater than 32

        case 2:
        B < number of digits in C
        A={0,2,3,4}
        B=2
        C=1000
        All 2-digit numbers will be lesser than 1000
        __ -> 4*4 = 16 - pow(A.size(), B) [no 0 in array]
        __ -> 3*4 = 12 - (A.size()-1)*pow(A.size(), B - 1) - [O in array]

        case 3:
        B = number of digits in C
        A={0,1,2,3,4}
        B = 2
        C = 23
        {10,11,12,13,14,20,21,22}
        We have to find approach where we find numbers having first digit less than or equal to 2 (C is 23 here)
        and then remove the numbers greater than 23

        Solution: https://youtu.be/MT8zeLak_bI
     */
    public static int solveNumbersOfLengthNAndValueLessThanK(int[] A, int B, int C) {
        if (A.length == 0) {
            return 0;
        }

        // find count of digits
        int temp = C;
        int count = 0;
        int ans = 0;
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        // case 1:
        if (count < B) {
            return 0;
        }
        // case 2
        else if (count > B) {
            if (A[0] == 0) {
                ans = (int) ((A.length - 1) * Math.pow(A.length, B - 1));
            } else {
                ans = (int) Math.pow(A.length, B);
            }
            if (B == 1 && A[0] == 0) {
                ans++;
            }
            return ans;
        }
        // case 3
        else {
            if (B == 1) { // 1 digit numbers that are less than C which would also be 1 digit since we are in else case
                for (int i = 0; i < A.length; i++) {
                    if (A[i] < C) {
                        ans++;
                    }
                }
            } else {
                int[] tmp = new int[B];
                // we are filling all digits of C in an array
                for (int i = B - 1; i >= 0; i--) {
                    tmp[i] = C % 10;
                    C = C / 10;
                }
                int countTemp = 0;
                // we will try to find everything which has numbers that start with first digit less than tmp[0] and
                // equal to that first digit
                for (int i = 0; i < A.length; i++) {
                    // Digit 0 in the array A has to be ignored if it is first
                    if (A[i] == 0) {
                        continue;
                    }
                    if (A[i] > tmp[0]) {
                        break;
                    }
                    countTemp++;
                }
                ans += (countTemp) * Math.pow(A.length, B - 1);
                // LOOK HERE1: this answer contains extra values i.e. some values greater than B too.

                // this logic is used to check if we at least contain first digit of C in array A
                int flag = 0, j = 0;
                for (int i = 0; i < A.length; i++) {
                    if (A[i] == tmp[j]) {
                        flag = 1;
                    }
                }
                j++; // so first digit is present in the array A, so we add 1 to j

                //
                while (flag == 1 && j <= B - 1) {
                    flag = 0;
                    int countx = 0;
                    for (int i = 0; i < A.length; i++) {
                        // the below if condition would compare the next digit in C and see if anything is more than
                        // that present
                        // e.g. 0,1,2,5
                        // B= 2 C=21
                        // numbers generated would be: 10 11 12 15 20 21 25
                        // as mentioned in LOOK HERE1 (search for it in code)
                        // so here 25 has to be removed
                        if (A[i] > tmp[j]) {
                            countx++;
                        }
                        if (A[i] == tmp[j]) {
                            flag = 1;
                        }
                    }
                    ans -= ((countx) * Math.pow(A.length, B - j - 1));
                    j++;
                }
                // This portion is used to remove the exact value of C since in previous code, it will be present
                if (j == B && flag == 1) {
                    ans--;
                }
            }
        }
        return ans;
    }
}
