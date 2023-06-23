package leetcode.topinterview150;

import java.util.Arrays;

/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.



Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Candy {
    public static void main(String[] args) {
        System.out.println(new Candy().candy(new int[]{1, 0, 2}));
    }

    //https://youtu.be/PzBYQA6FshA

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n + 1];
        Arrays.fill(left, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        int right = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right++;
                left[i] = Math.max(left[i], right);
            } else {
                right = 1;
            }
        }

        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += left[j];
        }
        return sum;
    }
}
