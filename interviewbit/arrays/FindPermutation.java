package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Stack;

/*
Given a positive integer n and a string s consisting only of letters D or I,
you have to find any permutation of first n positive integer that satisfy the given input string.
D means the next number is smaller, while I means the next number is greater.

Notes
Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
Example :
Input 1:
n = 3
s = ID

Return: [1, 3, 2]
 */
public class FindPermutation {
    public static void main(String[] args) {
        System.out.println(solveFindPermutation("ID", 3));
        System.out.println(solveFindPermutations("ID", 3));
    }

    // Approach 1
    public static ArrayList<Integer> solveFindPermutation(final String A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        int n = A.length();
        for (int i = 0; i < n; i++) {
            count++;
            stack.push(count);
            if (A.charAt(i) == 'I') {
                while (!stack.empty()) {
                    result.add(stack.peek());
                    stack.pop();
                }
            }
        }
        stack.push(count + 1);
        while (!stack.empty()) {
            result.add(stack.peek());
            stack.pop();
        }
        return result;
    }

    // Approach 2
    public static ArrayList<Integer> solveFindPermutations(final String A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = B - 1;
        int start = 1, end = 0;
        for (int i = 0; i < n; i++) {
            end++;
            if (A.charAt(i) == 'I') {
                for (int j = end; j >= start ; j--) {
                    result.add(j);
                }
                start = end + 1;
            }
        }
        end++;
        for (int j = end; j >= start ; j--) {
            result.add(j);
        }
        return result;
    }

}
