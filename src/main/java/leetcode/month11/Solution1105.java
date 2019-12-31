package leetcode.month11;

/**
 * @Author: 小霸王
 * @Date: 2019/11/5 14:15
 * <p>
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
public class Solution1105 {

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        if (root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
