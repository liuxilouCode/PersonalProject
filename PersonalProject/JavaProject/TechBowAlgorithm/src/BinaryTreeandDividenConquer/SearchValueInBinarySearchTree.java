package BinaryTreeandDividenConquer;

/**
 * @Author Yi Liu
 * @Date 8/3/22
 * @SpecificTime 4:37 PM
 * Given a binary search tree, find the target float number. If no such float number exists,
 * find and return the the only one closest number with unique value.
 * 问唯一的解是因为binary search tree可能最多有两个closest number
 * 假设target是 5   左子树是4.5 右子树是5.5 那就要return两个tree node
 *
 */
public class SearchValueInBinarySearchTree {
    public TreeNode searchClosestValue(TreeNode root, float target){
        //notice since the target is float, we cannot use == to check whether the values of two tree nodes are the same
        if (root == null) return null;
        TreeNode curr = root;
        TreeNode result = root; //global closest that records the current closest node and updates whenever finds a closer one
        while (curr!=null){
            if (curr.value == target){return curr;}
            if (Math.abs(curr.value - target) < Math.abs(result.value - target)){
                result = curr;
            }
            else if (curr.value > target){
                curr = curr.left;
            } else curr = curr.right;

        } //if the loop is already done but we still haven't returned any node, then the closest one
        //will be the result that has left there
        return result;
    }

    //we then implement a method that returns the exact target
    public TreeNode searchValue(TreeNode root, float target){
        if (root == null) return null;
        TreeNode curr = root;
        while(curr != null){
            if (curr.value == target) return curr;
            else if (curr.value < target) curr = curr.right;
            else curr = curr.left;
        }
        return null;
    }
}
