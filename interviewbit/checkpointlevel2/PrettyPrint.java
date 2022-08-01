package interviewbit.CheckPointLevel2;

import java.util.ArrayList;
import java.util.Arrays;

/*
Print concentric rectangular pattern in a 2d matrix. 

Let us show you some examples to clarify what we mean.

Example 1:

Input: A = 4.

Output:

4 4 4 4 4 4 4 
4 3 3 3 3 3 4 
4 3 2 2 2 3 4 
4 3 2 1 2 3 4 
4 3 2 2 2 3 4 
4 3 3 3 3 3 4 
4 4 4 4 4 4 4 
Example 2:

Input: A = 3.

Output:

3 3 3 3 3 
3 2 2 2 3 
3 2 1 2 3 
3 2 2 2 3 
3 3 3 3 3 
The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */
public class PrettyPrint {
    public static void main(String[] args) {
        System.out.println(prettyPrint(4));
    }

    public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Integer[][] resultArray = new Integer[2 * A - 1][2 * A - 1];
        resultArray[A - 1][A - 1] = 1;
        for (int i = 0; i < 2 * A - 1; i++) {
            for (int j = 0; j < 2 * A - 1; j++) {
                resultArray[i][j] = 1 + Math.max(Math.abs(i - A + 1), Math.abs(j - A + 1));
            }
        }
        for (int i = 0; i < 2 * A - 1; i++) {
            ArrayList<Integer> al = new ArrayList<>(Arrays.asList(resultArray[i]));
            result.add(al);
        }
        return result;
    }
}
