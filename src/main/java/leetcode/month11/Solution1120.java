package leetcode.month11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: 小霸王
 * @Date: 2019/11/20 14:50
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Solution1120 {

    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        treeQueue.add(root);
        while (!treeQueue.isEmpty()){
            TreeNode leftTree = treeQueue.poll();
            TreeNode rightTree = treeQueue.poll();
            if (leftTree == null && rightTree == null)
                continue;
            if (leftTree == null || rightTree == null)
                return false;
            if (leftTree.val != rightTree.val)
                return false;
            treeQueue.add(leftTree.left);
            treeQueue.add(rightTree.right);
            treeQueue.add(leftTree.right);
            treeQueue.add(rightTree.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left,root.right);
    }

    public boolean helper(TreeNode leftTree, TreeNode rightTree){
        if (leftTree == null && rightTree == null)
            return true;
        if (leftTree == null || rightTree == null)
            return false;
        return (leftTree.val == rightTree.val) && helper(leftTree.left,rightTree.right) && helper(leftTree.right,rightTree.left);
    }
}
