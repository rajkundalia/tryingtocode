package leetcode.topinterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course
bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers,
return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0.
So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = {{1,0},{2,0},{3,1},{3,2}}
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseScheduleII()
                .findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }

    //https://youtu.be/_BGK0kpE4oE?si=nUep1yZkD04PaV84
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && dfs(i, adj, s, visited)) {
                return new int[0];
            }
        }
        Collections.reverse(s);
        return s.stream().mapToInt(Integer::intValue).toArray();

    }

    private boolean dfs(int u, List<List<Integer>> adj, List<Integer> s, int[] visited) {
        visited[u] = 1;
        List<Integer> eligibleCourses = adj.get(u);

        for (int eligibleCourse : eligibleCourses) {
            if (visited[eligibleCourse] == 1) {
                return true;
            }
            if (visited[eligibleCourse] == 0 && dfs(eligibleCourse, adj, s, visited)) {
                return true;
            }
        }
        visited[u] = 2;
        s.add(u);
        return false;
    }
}
