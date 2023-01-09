package interviewbit.treedatastructure;

/*
Given a binary tree, find its maximum depth.
The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to
the farthest leaf node.

NOTE : The path has to end on a leaf node.
Example :
         1
        /
       2
    max depth = 2.
 */
public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;

        //System.out.println(new MaxDepthOfBinaryTree().maxDepth(root));
        System.out.println(new MaxDepthOfBinaryTree().maxDepth_1(root));
    }

    public int maxDepth(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(A.left), maxDepth(A.right));
    }

    /* 
         Solution 2:
     */    
    public int maxDepth_1(TreeNode A) {
        return depth(A, 0);
    }

    public int depth(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        int left = depth(node.left, level + 1);
        int right = depth(node.right, level + 1);
        return Math.max(left, right);
    }
         
     /*
        Solution 3:
     */
    public int maxDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            int l = maxDepth_2(root.left);
            int r = maxDepth_2(root.right);
            return (1 + (Math.max(l, r)));
        }
    }

}
