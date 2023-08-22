package leetcode.topinterview150;

/*
Given the root of a Binary Search Tree (BST), return the minimum absolute difference
between the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1
 */
public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        root.right = node6;

        node2.left = node1;
        node2.right = node3;

        System.out.println(new MinimumAbsoluteDifferenceInBST().getMinimumDifference(root));
    }

    /*
        Lets first see what the question says!!!!

        we have to find the minimum absolute difference of nodes!!
        thus 1st thing that pops in mind-difference of two nodes
        second thing-absolute difference
        BUT hey stop.we know its a BST
        so we can just compare the parent node.val and child node.val i.e parent.val-child.val!!
        this difference will never less than zero(why?
        because parent is always > than child!!
        so NO MATH.ABS !!
        now we need to compare in the fly (we are not using any extra space)
        so we need the closest difference together.thus we need increasing order of node values(as we need minimum)
        now we need to traverse!!
        we have 3 choices!!
        inorder,preorder,postorder!!
        which will benefit us!!!!
        lets try post order!!
        we get L R N (left right node)
        thus we are getting smallest value first then greatest then intermediate-not useful
        lets try preorder
        we get NLR
        we get intermediate ,smallest,greatest-not useful
        oh shit only one option left
        lets try inorder
        we get LNR
        thus we get smallest ,intermediate,greatest!!
        voila !!!
        we get increasing sequence!
        now we know we have to traverse INORDER
     */

    int min = Integer.MAX_VALUE;
    Integer previous = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }

        getMinimumDifference(root.left);

        if (previous != null) {
            min = Math.min(min, root.val - previous);
        }

        previous = root.val;

        getMinimumDifference(root.right);
        return min;
    }
}
