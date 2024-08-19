package BinaryTreeandDividenConquer;

/**
 * @Author Yi Liu
 * @Date 7/31/22
 * @SpecificTime 5:50 PM
 */
public class IsSameBinaryTree {
    public static boolean isSameBinaryTree(TreeNode rootFirst,TreeNode rootSecond){
        if (rootFirst == null && rootSecond == null){return true;}
        if (rootFirst == null || rootSecond == null){return false;}
        if (rootFirst.value != rootSecond.value){return false;}
        return isSameBinaryTree(rootFirst.left,rootSecond.left)&&
                isSameBinaryTree(rootFirst.right,rootSecond.right);
        //time complexity O(n), space complexity O(n)
    }
}
