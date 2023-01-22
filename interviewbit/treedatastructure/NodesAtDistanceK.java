package interviewbit.treedatastructure;

import java.util.ArrayList;

/*
Given the root of a binary tree A, the value of a target node B, and an integer C,
return an array of the values of all nodes that have a distance C from the target node.

You can return the answer in any order.

Problem Constraints
1 ≤ N ≤ 105 (N is the number of nodes in the binary tree)
1 ≤ Ai ≤ N (Ai denotes the values of the nodes in the tree)
All the values in the nodes are unique.
1 ≤ C ≤ 104

Input Format
The first argument is the root node of the binary tree A.
The second argument is an integer B denoting the label of the target node.
The third argument is an integer C denoting the distance.

Output Format
Return an array of integers denoting the nodes which are at a distance C from the node B.

Example Input
Input 1:
A =     1
       / \
      2   3
     / \
    4   5

B = 2
C = 1

Input 2:
A =     1
       / \
      2   3
     / \
    4   5

B = 2
C = 2

Example Output
Output 1:
[1, 4, 5]
Output 2:
[3]

Example Explanation
Explanation 1:
For the given tree, we have target node as 2.
All the nodes with are at distance 1, meaning the adjacent nodes are [1, 4, 5].

Explanation 2:
The given tree is same, and [3] is the only node with distance 2.
 */
public class NodesAtDistanceK {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        System.out.println(new NodesAtDistanceK().distanceK(root, 2, 2));
    }

    public ArrayList<Integer> distanceK(TreeNode A, int B, int C) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(A, B, C, res);
        return res;
    }

    private int traverse(TreeNode root, int b, int c, ArrayList<Integer> res) {
        if (root == null) {
            return -1;
        }
        if (root.val == b) {
            findNodesBelow(root, c, res);
            return 1;
        }
        int dist = traverse(root.left, b, c, res);
        if (dist != -1) {
            if (c - dist == 0) {
                res.add(root.val);
            }
            findNodesBelow(root.right, c - dist - 1, res);
            return dist + 1;
        }
        dist = traverse(root.right, b, c, res);
        if (dist != -1) {
            if (c - dist == 0) {
                res.add(root.val);
            }
            findNodesBelow(root.left, c - dist - 1, res);
            return dist + 1;
        }
        return -1;
    }

    private void findNodesBelow(TreeNode root, int c, ArrayList<Integer> res) {
        find(root, c, res, 0);
    }

    private void find(TreeNode root, int c, ArrayList<Integer> res, int level) {
        if (root == null || c < 0) {
            return;
        }
        if (c == level) {
            res.add(root.val);
            return;
        }
        find(root.left, c, res, level + 1);
        find(root.right, c, res, level + 1);
    }
}
