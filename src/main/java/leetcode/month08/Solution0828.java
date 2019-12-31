package leetcode.month08;

/**
 * @Author: DuanTong
 * @Date: 2019/8/28 15:21
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Solution0828 {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        //return max(root);
        return max(root);
    }

    public int max(TreeNode node){
        if (node == null)
            return 0;
        else {
            int left = max(node.left);
            int right = max(node.right);
            return left >= right ? left + 1 : right + 1;
        }

    }

}
