package leetcode.topinterview150;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital,
LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources,
it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize
its total capital after finishing at most k distinct projects.

You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is
needed to start it.

Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added
to your total capital.

Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final
maximized capital.

The answer is guaranteed to fit in a 32-bit signed integer.

Example 1:

Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4
Explanation: Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.

Example 2:
Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
Output: 6
 */
public class IPO {
    public static void main(String[] args) {
        System.out.println(new IPO().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
    }

    /*
    1. Create a vector of pairs "projects" to store the minimum capital required and pure profit of each project.
    2. Initialize a variable "n" to the size of the input "profits" vector.
    3. Sort the "projects" vector by the minimum capital required in ascending order.
    4. Initialize a variable "i" to 0 and a priority queue "maximizeCapital" to store the maximum profit we can
       get from a project.
    5. Loop k times and perform the following operations in each iteration:
        a. While "i" is less than "n" and the minimum capital required for the project at index "i" is less than or
           equal to the current capital "w", push the profit of the project at index "i" to "maximizeCapital" and increment "i".
        b. If "maximizeCapital" is empty, break out of the loop.
        c. Add the maximum profit in "maximizeCapital" to "w" and pop it out of the priority queue.
    6. Return the final value of "w".
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        PriorityQueue<Integer> maximizeCapital = new PriorityQueue<>(Collections.reverseOrder());

        while (k-- > 0) {
            while (i < n && projects[i][0] <= w) {
                maximizeCapital.offer(projects[i][1]);
                i++;
            }
            if (maximizeCapital.isEmpty()) {
                break;
            }
            w += maximizeCapital.poll();
        }
        return w;
    }
}
