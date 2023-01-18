package interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Stack;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class RootToLeafPathsWithSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node11.left = node7;
        node11.right = node2;

        node4_2.left = node5;
        node4_2.right = node1;

        node8.left = node13;
        node8.right = node4_2;

        node4.left = node11;

        root.left = node4;
        root.right = node8;

        System.out.println(new RootToLeafPathsWithSum().pathSum(root, 22));

    }

    public RootToLeafPathsWithSum() {
        resultList = new ArrayList<>();
    }

    private ArrayList<ArrayList<Integer>> resultList;

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        if (A == null) {
            return resultList;
        }
        Stack<Integer> path = new Stack<>();
        pathSumInner(A, B, path);
        return resultList;
    }

    private void pathSumInner(TreeNode a, int b, Stack<Integer> path) {
        path.push(a.val);

        if (a.left == null && a.right == null) {
            if (b == a.val) {
                resultList.add(new ArrayList<>(path));
            }
        }
        if (a.left != null) {
            pathSumInner(a.left, b - a.val, path);
        }

        if (a.right != null) {
            pathSumInner(a.right, b - a.val, path);
        }

        path.pop();
    }
}
