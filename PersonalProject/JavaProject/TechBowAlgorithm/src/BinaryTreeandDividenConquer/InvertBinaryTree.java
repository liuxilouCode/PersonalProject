package BinaryTreeandDividenConquer;

/**
 * @Author Yi Liu
 * @Date 7/31/22
 * @SpecificTime 4:46 PM
 */
public class InvertBinaryTree {
    public TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        //先recursion后办事儿 bottoms up
        TreeNode leftNode = invertBinaryTree(root.left);
        //wall
        TreeNode rightNode = invertBinaryTree(root.right);
        //wall
        root.left = rightNode;
        root.right = leftNode;
        return root;
        //time complexity is O(n)
    }

    //Advanced question: based on inverting binary tree, please check whether a binary tree is symmetric


    public static boolean isSymmetric(TreeNode root){
        return root == null?true:mirror(root.left,root.right);

    }
    //we need a helper function
    private static boolean mirror(TreeNode left, TreeNode right){//helper
        //办事条件顺序不能换 先办事后recursion tops down recursion
        if (left == null && right == null){return true;}
        if (left == null || right == null){return true;}
        if (left.value != right.value){return false;}
        return mirror(left.left,right.right) && mirror(left.right,right.left);
        //这里别忘了是symmetric，镜像，所以要 最左和最右比，中左和中右比
    }
}
