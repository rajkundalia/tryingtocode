package interviewbit.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
There are a total of A courses you have to take, labeled from 1 to A.
Some courses may have prerequisites, for example to take course 2 you have to first take course 1,
which is expressed as a pair: [1,2].
The pairs are given as two arrays B and C, where [B[i], C[i]] form a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

Problem Constraints
1 <= A <= 105
1 <= length(B) = length(C) <= 105
1 <= B[i], C[i] <= A

Input Format
The first argument of input contains an integer A, representing the number of courses.
The second argument of input contains an integer array, B.
The third argument of input contains an integer array, C.

Output Format
Return a boolean value:
1 : If it is possible to complete all the courses.
0 : If it is not possible to complete all the courses.

Example Input
Input 1:
A = 3
B = [1, 2]
C = [2, 3]
Input 2:
A = 2
B = [1, 2]
C = [2, 1]

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
It is possible to complete the courses in the following order:
1 -> 2 -> 3
Explanation 2:
It is not possible to complete all the courses.
 */
public class PossibilityOfFinishingAllCoursesGivenPreRequisites {
    public static void main(String[] args) {
        System.out.println(new PossibilityOfFinishingAllCoursesGivenPreRequisites().solve(3, new int[]{1, 2}, new int[]{2, 3}));
    }

    public int solve(int A, int[] B, int[] C) {
        ArrayList<Integer>[] adjacencyList = new ArrayList[A + 1];
        int[] indegree = new int[A + 1];
        boolean[] visited = new boolean[A + 1];

        for (int i = 1; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < B.length; i++) {
            int source = B[i];
            int destination = C[i];
            adjacencyList[source].add(destination);
            indegree[destination]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= A; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                visited[i] = true;
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ArrayList<Integer> list = adjacencyList[node];

            for (int x : list) {
                if (!visited[x]) {
                    indegree[x] -= 1;
                    if (indegree[x] == 0) {
                        visited[x] = true;
                        count++;
                        queue.add(x);
                    }
                }
            }
        }

        if (count == A) {
            return 1;
        }

        return 0;
    }
}
