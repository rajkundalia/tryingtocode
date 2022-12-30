package interviewbit.treedatastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
Given a binary tree A of integers. Return an array of integers representing the right view of the Binary tree.
Right view of a Binary Tree: is a set of nodes visible when the tree is visited from Right side.

Problem Constraints
1 <= Number of nodes in binary tree <= 105
0 <= node values <= 109

Input Format
First and only argument is an pointer to the root of binary tree A.

Output Format
Return an integer array denoting the right view of the binary tree A.

Example Input
Input 1:
        1
      /   \
     2    3
    / \  / \
   4   5 6  7
             \
             8

Input 2:
    1
   /  \
  2    3
   \
    4
     \
      5

Example Output
Output 1:
 [1, 3, 7, 8]
Output 2:
 [1, 3, 4, 5]
 */
public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node1.right = node3;
        node3.right = node4;
        root.left = node1;
        root.right = node2;
        System.out.println(new RightViewOfBinaryTree().solve(root));
    }

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        if (A == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);

        TreeNode current;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;

            while (i++ < size) {
                current = queue.poll();

                // if this is the last node of the current level, print it
                if (i == size) {
                    result.add(current.val);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return result;
    }
}

/*
Input 2:
    1
   /  \
  2    3
   \
    4
     \
      5

public class Solution {
    TreeMap<Integer, Integer> tm;
    ArrayList<Integer> alist;
    Solution(){
        tm = new TreeMap<Integer,Integer>();
        alist = new ArrayList<Integer>();
    }
    public ArrayList<Integer> solve(TreeNode A) {
        findView(A,0);
        return alist;
    }
    void findView(TreeNode node, int count){
        if(node==null) return;
        if (alist.size() == count) {
            alist.add(node.val);
        }
        findView(node.right, count+1);
        findView(node.left, count+1);
    }
}
 */