package interviewbit.heapsandmaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Given an array A, representing seats in each row of a stadium. You need to sell tickets to B people.
Each seat costs equal to the number of vacant seats in the row it belongs to.
The task is to maximize the profit by selling the tickets to B people.

Problem Constraints
1 <= |A| <= 100000
1 <= B <= 1000000

Input Format
First argument is the array A.
Second argument is integer B.

Output Format
Return one integer, the answer to the problem.

Example Input
Input 1:
A = [2, 3]
B = 3
Input 2:
A = [1, 4]
B = 2

Example Output
Output 1:
7
Output 2:
7

Example Explanation
Explanation 1:
 First you serve the seat with number = 3. Then with 2 and then with 2. hence answer = 3 + 2 + 2 = 7.
Explanation 2:
 You give both tickets from the row with 4 seats. 4 + 3 = 7.
 */
public class ProfitMaximisation {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(2, 3)), 3));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        // PriorityQueue for max heap
        // By default priority queue is min heap
        // we want to maximize profit that is reason we are using max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // add all the elements into the heap
        for(int x: A) pq.add(x);
        int ans = 0;

        while (B-- > 0) {
            int val = pq.poll();
            ans += val;
            // add remaining tickets to priority queue
            pq.add(val - 1);
        }

        return ans;
    }
}
