package leetcode.month10;

/**
 * @Author: DuanTong
 * @Date: 2019/10/17 14:58
 */
public class Solution1017 {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    public TreeNode invert(TreeNode tree){
        if (tree == null)
            return tree;
        TreeNode temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        tree = invertTree(tree.left);
        tree = invertTree(tree.right);
        return tree;
    }

}
