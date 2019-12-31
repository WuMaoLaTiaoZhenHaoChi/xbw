package leetcode.month10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: DuanTong
 * @Date: 2019/10/18 15:16
 * 给定一个二叉树，返回它的中序 遍历。
 */
public class Solution1018 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()){
            while (temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            list.add(temp.val);
            temp = temp.right;
        }
        return list;
    }


/*    public void inorder(TreeNode root){
        if (root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }*/

/*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return inorder(root,list);
    }

    public List<Integer> inorder(TreeNode root,List<Integer> list){
        if (root == null)
            return list;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
        return list;
    }
*/

}
