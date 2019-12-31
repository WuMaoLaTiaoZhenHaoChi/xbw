package leetcode.month10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/10/29 16:09
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Solution1029 {

    private List<List<Integer>> retList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root,0);
        return retList;
    }

    public void helper(TreeNode root, int level){
        if (root == null)
            return;
        if (level > retList.size() - 1){
            List<Integer> levelList = new ArrayList<Integer>();
            retList.add(levelList);
        }
        retList.get(level).add(root.val);
        if (root.left != null || root.right != null){
            level += 1;
        }
        helper(root.left,level);
        helper(root.right,level);
    }

}
