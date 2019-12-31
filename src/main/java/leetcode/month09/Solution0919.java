package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/19 16:44
 *
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class Solution0919 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        sum(root);
        return maxSum;
    }

    public int sum(TreeNode tree){

        if (tree == null)
            return 0;

        //左子树，小于0的舍弃
        int leftSum = Math.max(sum(tree.left),0);
        //右子树，小于0的舍弃
        int rightSum = Math.max(sum(tree.right),0);
        //计算节点 + 左子树 + 右子树
        int sum = leftSum + rightSum + tree.val;
        //舍弃较小的和
        maxSum = Math.max(maxSum,sum);
        //加上节点
        return tree.val + Math.max(leftSum,rightSum);
    }

}
