package BreadthFirstSearch;

import BinaryTreeandDividenConquer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Yi Liu
 * @Date 8/12/22
 * @SpecificTime 3:01 PM
 */
public class IsCompleteBinaryTree {
    //利用bfs的方法判断是不是满二叉树
    public boolean isComplete(TreeNode root){
        if (root == null) return true;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag = false;
        while (!que.isEmpty()){
            TreeNode pollNode = que.poll();
            if (pollNode == null) flag = true;
            else {
                if (flag == true) return false; //如果que没满，但是flag=true，说明que中前一个节点是空节点，即本节点的同层或上层出现了空节点，则必定不是满二叉树
                que.offer(pollNode.left);
                que.offer(pollNode.right);
            }
        }
        return true;
    } //这个代码的逻辑是  无论node是不是null，que都会收进去

    //那有没有一种可能，程序只offer非空节点，这样无法在que中判断是否有null
    public boolean isCompleteBinary(TreeNode root){
        if (root == null) return true;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag = false;
        while(!que.isEmpty()){
            TreeNode pollNode = que.poll();
            if (pollNode.left != null){
                if (flag == true) return false;
                que.offer(pollNode.left);
            } else flag = true; //这里就是直接判断poll出来的node的left和right是不是为空，是的话直接确定是非满二叉树
            //这里的逻辑是，如果代码能走到这里，假设flag已经是true了，即左子节点是空
            if (pollNode.right != null){
                //但走到这里右子树并非空，那直接就可以说明二叉树是非满
                if (flag == true) return false;
                que.offer(pollNode.right);
            } else flag = true;
        }
        return true;
    }
}
