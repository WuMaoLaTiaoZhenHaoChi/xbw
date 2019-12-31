package leetcode.month08;

/**
 * @Author: DuanTong
 * @Date: 2019/8/24 10:20.
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Solution0824 {

    private TreeNode tNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
/*        if (p.val > q.val){
            TreeNode tempNode = p;
            p = q;
            q = tempNode;
        }*/

        if (p.val > q.val)
            lowestCommonAncestor(root,q,p);

        if (root.left == null || root.right == null){
            if ( p.val <= root.val || q.val >= root.val)
                this.tNode = root;
        }else {
            if ( p.val <= root.val && q.val >= root.val)
                this.tNode = root;
        }


        if (p.val > root.val && q.val > root.val)
            lowestCommonAncestor(root.right,p,q);
        if (p.val < root.val && q.val < root.val)
            lowestCommonAncestor(root.left,p,q);

        return this.tNode;
    }

}

