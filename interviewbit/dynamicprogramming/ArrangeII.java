package interviewbit.dynamicprogramming;

/*
You are given a sequence of black and white horses, and a set of K stables numbered 1 to K.
You have to accommodate the horses into the stables in such a way that the following conditions are satisfied:

You fill the horses into the stables preserving the relative order of horses. For instance,
you cannot put horse 1 into stable 2 and horse 2 into stable 1. You have to preserve the ordering of the horses.
No stable should be empty and no horse should be left unaccommodated.

Take the product (number of white horses * number of black horses) for each stable and take the sum of
all these products. This value should be the minimum among all possible accommodation arrangements
Example:

Input: {WWWB} , K = 2
Output: 0

Explanation:
We have 3 choices {W, WWB}, {WW, WB}, {WWW, B}
for first choice we will get 1*0 + 2*1 = 2.
for second choice we will get 2*0 + 1*1 = 1.
for third choice we will get 3*0 + 0*1 = 0.

Of the 3 choices, the third choice is the best option.

If a solution is not possible, then return -1
 */
public class ArrangeII {
    public static void main(String[] args) {
        System.out.println(new ArrangeII().arrange("WWWB", 2));
    }

    /*
    Recurrence relation


Rec(Current_Horse, Current_Stable) =  |
                                      |           |
                                      |           |Rec(i + 1, Next_Stable) + (White_Horses * Black Horses in Current_Stable)
                                      |       min |
                                      |           |
                                      |
                                      | i = Current_Horse to Number_of_Horses
                                      |
     */

    public int arrange(String A, int B) {
        //C(m, k) = P (j to m) + C(j, k - 1)
        int[][] dp = new int[A.length() + 1][B + 1];
        if (A.length() < B) {
            return -1;
        }
        for (int i = 1; i <= A.length(); i++) {
            dp[i][1] = product(A, 0, i - 1);
        }

        // Product
        for (int k = 2; k <= B; k++) {
            for (int j = k; j <= A.length(); j++) {
                int min = Integer.MAX_VALUE;
                for (int i = k - 1; i <= j - 1; i++) {

                    dp[j][k] = Math.min((dp[i][k - 1] + product(A, i, j - 1)), min);//i = 2 j = 4
                    min = dp[j][k];
                }
            }
        }

        return dp[A.length()][B];

    }

    public int product(String A, int start, int end) {
        int W = 0, B = 0;
        for (int i = start; i <= end; i++) {
            if (A.charAt(i) == 'W') W++;
            else if (A.charAt(i) == 'B') B++;
        }
        return W * B;
    }
}
