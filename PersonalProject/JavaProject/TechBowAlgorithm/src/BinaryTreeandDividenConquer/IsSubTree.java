package BinaryTreeandDividenConquer;

/**
 * @Author Yi Liu
 * @Date 7/31/22
 * @SpecificTime 6:11 PM
 */
public class IsSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        return IsSameBinaryTree.isSameBinaryTree(root, subRoot) ||
                isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    //I can also build a helper function within the method so I don't have to call it from another class
    private boolean checkEqualHelper(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        return root.value == subRoot.value &&
                checkEqualHelper(root.left, subRoot.left) &&
                checkEqualHelper(root.right, subRoot.right);
    }
}
