package leetcode.month10;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DuanTong
 * @Date: 2019/10/27 11:25
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class Solution1026 {

    int pre_index = 0;
    Map<Integer,Integer> inorder_map = new HashMap<>();
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int index = 0;
        for (int val : inorder)
            inorder_map.put(inorder[index],index++);
        return helper(0,preorder.length);
    }

    public TreeNode helper(int left, int right){
        if (left == right)
            return null;
        int root_val = preorder[pre_index];
        TreeNode root_tree = new TreeNode(root_val);
        int root_index = inorder_map.get(root_val);
        pre_index++;
        root_tree.left = helper(left,root_index);
        root_tree.right = helper(root_index + 1,right);
        return root_tree;
    }



}
