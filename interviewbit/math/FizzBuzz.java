package interviewbit.math;

import java.util.ArrayList;

/*
Fizzbuzz is one of the most basic problems in the coding interview world.
Try to write a small and elegant code for this problem.

Given a positive integer A, return an array of strings with all the integers from 1 to N.
But for multiples of 3 the array should have “Fizz” instead of the number.
For the multiples of 5, the array should have “Buzz” instead of the number.
For numbers which are multiple of 3 and 5 both, the array should have “FizzBuzz” instead of the number.

Look at the example for more details.
Example:
A = 5
Return: [1 2 Fizz 4 Buzz]
 */
public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(solveFizzBuzz(5));
        System.out.println(solveFizzBuzz1(5));
        System.out.println(solveFizzBuzz2(5));
    }

    public static ArrayList<String> solveFizzBuzz2(int A) {
        ArrayList<String> result = new ArrayList<>();
        int c3 = 0;
        int c5 = 0;
        for (int i = 1; i <= A; i++) {
            c3++;
            c5++;
            String d = "";
            if (c3 == 3) {
                d += "Fizz";
                c3 = 0;
            }
            if (c5 == 5) {
                d += "Buzz";
                c5 = 0;
            }
            if (d == "") {
                d += i;
            }
            result.add(d);
        }
        return result;
    }

    public static ArrayList<String> solveFizzBuzz1(int A) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            String d = "";
            if (i % 3 == 0) {
                d += "Fizz";
            }
            if (i % 5 == 0) {
                d += "Buzz";
            }
            if (d == "") {
                d += i;
            }
            result.add(d);
        }
        return result;
    }

    public static ArrayList<String> solveFizzBuzz(int A) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }

        }
        return result;
    }
}

