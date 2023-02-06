package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
You are given the root of a binary tree A.
You have to find the vertical sum of the tree.
A vertical sum denotes an array of sum of the different verticals of a binary tree,
where the leftmost vertical sum is the first element of the array and rightmost vertical is the last.

Problem Constraints
1 <= Number of nodes in the binary tree <= 105
1 <= Ai <= 103

Input Format
The first argument is the root of a binary tree A.

Output Format
Return an array denoting the vertical sum of the binary tree.

Example Input
Input 1:
A =     1
      /   \
     2     3
    / \   / \
   4   5 6   7
Input 2:
A =     1
       /
      2
     /
    3

Example Output
Output 1:
[4, 2, 12, 3, 7]
Output 2:

[3, 2, 1]

Example Explanation
Explanation 1:
The element 4 is present in the leftmost vertical.
The middle vertical consists of 3 elements 1, 5, 6.
The resultant array is [4, 2, 12, 3, 7].
Explanation 2:

The leftmost vertical is the element 3. The next verticals are 2 and 1.
Hence, the resultant array is [3, 2, 1].
 */
public class VerticalSumOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        node2.left = node3;

        System.out.println(new VerticalSumOfABinaryTree().verticalSum(root));
    }

    public ArrayList<Integer> verticalSum(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        if (A == null) {
            return result;
        }

        Map<Integer, Integer> map = new TreeMap<>();

        verticalSumHelper(A, map, 0);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private void verticalSumHelper(TreeNode a, Map<Integer, Integer> map, int i) {
        if(a == null) {
            return;
        }
//        if(!map.containsKey(i)) {
//            map.put(i, a.val);
//        } else {
//            map.put(i, map.get(i) + a.val);
//        }
        map.merge(i, a.val, Integer::sum);
        verticalSumHelper(a.left, map, i - 1);
        verticalSumHelper(a.right, map, i + 1);
    }
}
