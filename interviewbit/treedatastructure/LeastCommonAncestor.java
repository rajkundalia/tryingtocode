package interviewbit.treedatastructure;

/*
Find the lowest common ancestor in an unordered binary tree given two values in the tree.

Lowest common ancestor: the lowest common ancestor (LCA) of two nodes v and w in a tree or
directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.

Note:
You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn't exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, and helper functions, and can modify the node struct but, you can't add a parent pointer.

Input Format
The first argument is a TreeNode A, pointing to the root of the binary tree.
The second argument is an integer B.
The third argument is an integer C.

Output Format
Return an integer, equal to the value of the LCA of B and C.

Example Input
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4

B = 5
C = 1

Example Output
3

Example Explanation
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4

For the above tree, the LCA of nodes 5 and 1 is 3.
Please note that LCA for nodes 5 and 4 is 5.
 */
public class LeastCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;

        System.out.println(new LeastCommonAncestor().lca(root, 5, 0));
    }

    public int lca(TreeNode A, int B, int C) {
        if (!find(A, B) || !find(A, C)) {
            return -1;
        }
        return lcaUtil(A, B, C).val;
    }

    private TreeNode lcaUtil(TreeNode root, int b, int c) {
        if (root == null) {
            return null;
        }

        if (root.val == b || root.val == c) {
            return root;
        }

        TreeNode left = lcaUtil(root.left, b, c);
        TreeNode right = lcaUtil(root.right, b, c);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }

    public boolean find(TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        return find(root.left, val) || find(root.right, val);
    }
}
