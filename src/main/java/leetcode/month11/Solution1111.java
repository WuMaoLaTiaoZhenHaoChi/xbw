package leetcode.month11;

/**
 * @Author: 小霸王
 * @Date: 2019/11/11 11:22
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class Solution1111 {

    public int rob(TreeNode root) {
        TreeNode treeNode = robTree(root);
        return treeNode.val;
    }

    public TreeNode robTree(TreeNode root){
        if (root == null){
            TreeNode treeNode = new TreeNode(0);
            return robTree(treeNode);
        }

        if (root.left == null && root.right == null){
            root.left = new TreeNode(0);
            root.right = new TreeNode(0);
            return root;
        }
        root.left = robTree(root.left);
        root.right = robTree(root.right);
        root.val = Math.max(root.val + root.left.left.val + root.left.right.val + root.right.left.val + root.right.right.val,
                root.left.val + root.right.val);
        return root;
    }

}
