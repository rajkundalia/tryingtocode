package interviewbit.backtracking;

import java.util.ArrayList;

/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code,
print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
A gray code sequence must begin with 0.
 */
public class GrayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }

    // This is added because java does pass by value in case of primitive integers
    static class IntWrapper {
        int value;

        public IntWrapper(int value) {
            this.value = value;
        }
    }


    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        IntWrapper wrapper = new IntWrapper(0);
        backtrack(result, wrapper, n);
        return result;
    }

    private static void backtrack(ArrayList<Integer> result, IntWrapper x, int n) {
        if (n == 0) {
            result.add(new IntWrapper(x.value).value);
            return;
        }

        backtrack(result, x, n - 1);
        x.value = x.value ^ (1 << (n - 1));
        backtrack(result, x, n - 1);
    }

    public static ArrayList<Integer> grayCode_1(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }

}
