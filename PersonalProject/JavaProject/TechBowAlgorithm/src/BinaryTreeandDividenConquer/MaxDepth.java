package BinaryTreeandDividenConquer;

/**
 * @Author Yi Liu
 * @Date 7/31/22
 * @SpecificTime 1:51 PM
 *
 * Given a binary tree, get the maximum depth of binary tree.
 *  Implement getHeight (In fact, getHeight is the same as the maximum depth of binary tree)
 *  Minimum depth of binary tree
 */
public class MaxDepth {
    public static int getHeight(TreeNode root){
        if (root == null){return 0;}
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1; //+1是保证根节点不被漏掉
        //time complexity：O(n)
    }

    public int getMin(TreeNode root){
        if (root == null){return 0;}
        int leftHeight = getMin(root.left);
        int rightHeight = getMin(root.right);
        //做minimum的时候要考虑单边情况，因为单边情况的时候rightHeight或leftHeight中的一个会返回0 （别忘了if (root == null){return 0;}）
        //这样的话会少算一层
        //一种解决办法是base case的时候判断这个节点是不是子节点，但这样代码会变得复杂
        //本着keep your code dry的原则，在最后的return statement上动手逻辑合理，想起来也更容易
        return (leftHeight == 0 || rightHeight == 0)?
                leftHeight+rightHeight+1:
                Math.min(leftHeight,rightHeight)+1;
        //time complexity：O(n)
    }
}
