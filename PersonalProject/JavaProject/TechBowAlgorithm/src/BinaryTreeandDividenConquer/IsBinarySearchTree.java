package BinaryTreeandDividenConquer;

/**
 * @Author Yi Liu
 * @Date 8/2/22
 * @SpecificTime 1:31 PM
 * DEF: For every node x, all the values of the left subtree should be less than value of x.
 * All the values of the right subtree should be greater than the value of x.
 */
public class IsBinarySearchTree {
    public boolean isBST(TreeNode root){
        //Use min max to carry on the bound information and recurse from top to bottom
        return isBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        //We use infinity as the bounds so we can handle as many cases as possible
        //we need a helper function
    }

    private boolean isBSTHelper(TreeNode root, int lowerBound, int upperBound){ //todo long
        //Base case
        if (root == null){return true;}
        if (root.value >= upperBound || root.value <= lowerBound){return false;}
        return isBSTHelper(root.left,lowerBound,root.value) && isBSTHelper(root.right,root.value,upperBound);
    }
    //time complexity is O(n)
}
