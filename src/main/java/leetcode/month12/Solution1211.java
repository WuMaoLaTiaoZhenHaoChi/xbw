package leetcode.month12;

/**
 * @Author: duant
 * @Date: 2019/12/11 14:36
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 */
public class Solution1211 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode tree){
        if (null == tree) {
            return 0;
        }
        int left = helper(tree.left);
        int right = helper(tree.right);
        max = Math.max(left + right,max);
        return Math.max(left,right) + 1;
    }

}
