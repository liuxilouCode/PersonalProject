package DepthFirstSearch;

import BinaryTreeandDividenConquer.TreeNode;

/**
 * @Author Yi Liu
 * @Date 8/13/22
 * @SpecificTime 1:48 PM
 * 深度优先遍历，与广度优先的区别是，遍历的同时优先往下层走，而不是同层遍历
 */
public class DFS {
    //pre-order DFS
    public void DFS(TreeNode root){
        if (root == null) return;
        System.out.println(root.value);
        DFS(root.left);
        //wall
        DFS(root.right);
    }
}
