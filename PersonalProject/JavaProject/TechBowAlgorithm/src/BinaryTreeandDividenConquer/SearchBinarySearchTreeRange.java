package BinaryTreeandDividenConquer;

/**
 * @Author Yi Liu
 * @Date 8/3/22
 * @SpecificTime 4:21 PM
 *
 * Given a binary search tree, a bounded set, find out the range of the binary search tree
 * that is within the set.
 */
public class SearchBinarySearchTreeRange {
    public void searchRange(TreeNode root, int lowerBound, int upperBound){
        if (root == null){return;}
        if (root.value >= lowerBound && root.value <= upperBound){
            System.out.println(root.value);
        } else if (root.value > upperBound){
            searchRange(root.left,lowerBound,upperBound);
        } else if (root.value < lowerBound){
            searchRange(root.right,lowerBound,upperBound);
        }
    }
    //time complexity is ranged from O(log n) to O(n)
    // 因为有剪枝 最好的情况是只走一边
    //最坏的情况就是剪枝没发生，全部遍历一遍
}
