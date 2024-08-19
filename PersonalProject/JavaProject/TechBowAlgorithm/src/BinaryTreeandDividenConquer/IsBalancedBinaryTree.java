package BinaryTreeandDividenConquer;


/**
 * @Author Yi Liu
 * @Date 7/31/22
 * @SpecificTime 2:31 PM
 */
public class IsBalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
        //这是先办事后recursion，借助了getHeight方法
        if (root == null){
            return true;
        }
        //自上而下先判断左右子树高度差
        int leftHeight = MaxDepth.getHeight(root.left);
        int rightHeight = MaxDepth.getHeight(root.right);
        if (Math.abs(leftHeight-rightHeight)>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
        //这实际上不符合我们最喜欢的逻辑，因为如果自下而上判断，先recursion后办事，比较符合检查balanced binary tree的逻辑
        //而且时间复杂度很高 O(n*log n)
        //注意一个区分
        //return Math.abs(leftHeight-rightHeight)<=1 && isBalanced(root.left) && isBalanced(root.right);
        //这个写法也没有任何问题，是一样的，然而下面这种写法
        //return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftHeight-rightHeight)<=1;
        //虽然达到的目的相同，然而没有"剪枝"发生，即recursion要执行到底，用worst case的时间复杂度来完成整个代码
    }

    //因为发现getHeight在解决这类问题时有重复计算，我们也可以重写getHeight方法
    public int getHei(TreeNode root){
        if (root == null){return 0;}
        int leftHeight = getHei(root.left);
        int rightHeight = getHei(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        } //这一步判定就是一旦发现左右子树层数相差大于1，则立刻return -1，而且是全局return -1以致我们以最快的速度告诉isBalanced赶快return false
        return Math.max(leftHeight,rightHeight);
    }

    public boolean isBalance(TreeNode root){
        if (root == null){return true;}
        int leftHeight = getHei(root.left);
        if (leftHeight == -1){
            return false;
        }
        int rightHeight = getHei(root.right);
        if (rightHeight == -1){
            return false;
        }
        return (Math.abs(leftHeight-rightHeight)>1) && isBalanced(root.left) && isBalanced(root.right);
        //time complexity O(n)
    }

    //below is the bottom up recursive method, it needs a helper function first

    private TreeInfo isBalancedTreeHelper(TreeNode root) {
        // An empty tree is balanced and has height = -1
        if (root == null) {
            return new TreeInfo(-1, true);
        }

        // Check subtrees to see if they are balanced.
        TreeInfo left = isBalancedTreeHelper(root.left);
        if (!left.balanced) {
            return new TreeInfo(-1, false);
        }
        TreeInfo right = isBalancedTreeHelper(root.right);
        if (!right.balanced) {
            return new TreeInfo(-1, false);
        }

        // Use the height obtained from the recursive calls to
        // determine if the current node is also balanced.
        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }

    public boolean isBalancedTree(TreeNode root){
        return isBalancedTreeHelper(root).balanced;
    }
}
