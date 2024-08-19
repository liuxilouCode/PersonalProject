package BreadthFirstSearch;


import BinaryTreeandDividenConquer.TreeNode;

import java.util.*;

/**
 * @Author Yi Liu
 * @Date 8/7/22
 * @SpecificTime 5:03 PM
 * 宽度优先遍历
 * 即遍历一个binary tree时，一层遍历完后再遍历下一层
 */
public class LevelOrderTraversal {
    public void levelOrderTraversal(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            TreeNode pollNode = que.poll();
            System.out.println(pollNode);

            if (pollNode.left !=null){
                que.offer(pollNode.left);
            }
            if (pollNode.right != null){
                que.offer(pollNode.right);
            }
        }
        //能用while就少用recursion
    }
    //那如何实现分层打印？
    public void levelOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size(); //while loop每次重新算size是因为size会变
            for (int i = 0; i < size; i++) {
                TreeNode pollNode = que.poll();

                System.out.println(pollNode.value); //visit

                if (pollNode.left != null) {
                    que.offer(pollNode.left);
                }
                if (pollNode.right != null) {
                    que.offer(pollNode.right);
                }
            }
            System.out.println(); //每层结束的间隔
        }
    }

    //如果我们想实现逆bfs的方法打印，即从下到上，从左到右，其实可以先正着做，把数据记录下来，再reverse
    public List<List<Integer>> level(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return null;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size(); //while loop每次重新算size是因为size会变
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode pollNode = que.poll();
                list.add(pollNode.value);
                System.out.println(pollNode.value); //visit

                if (pollNode.left != null) {
                    que.offer(pollNode.left);
                }
                if (pollNode.right != null) {
                    que.offer(pollNode.right);
                }
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }

    //we can also make zig-zag order
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offerLast(root);
        boolean flag = false;
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (flag == false) {
                    TreeNode node = queue.pollFirst();// offer, poll, peek
                    list.add(node.value);
                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }
                } else {
                    TreeNode node = queue.pollLast();// offer, poll, peek
                    list.add(node.value);
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }

                }
            }
            flag = !flag; //通过flag来达到zig-zag的目的
            result.add(list);
        }
        return result;
    }

}
