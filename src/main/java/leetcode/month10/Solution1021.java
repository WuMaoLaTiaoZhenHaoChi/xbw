package leetcode.month10;

/**
 * @Author: DuanTong
 * @Date: 2019/10/21 14:19
 *
 * 给定一个二叉树，原地将它展开为链表。
 */
public class Solution1021 {

    private TreeNode tree = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = tree;
        root.left = null;
        tree = root;
    }

}
