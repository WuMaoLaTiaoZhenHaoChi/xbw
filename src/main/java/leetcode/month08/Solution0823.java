package leetcode.month08;


public class Solution0823 {
    private TreeNode TNode;

    Solution0823(){
        this.TNode = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.resouceTree(root,p,q);
        return this.TNode;
    }

    private int resouceTree(TreeNode midNode, TreeNode p, TreeNode q){
        if (midNode == null){
            return 0;
        }

        int left = resouceTree(midNode.left,p,q);

        int right = resouceTree(midNode.right,p,q);

        int mid = (midNode == p || midNode == q) ? 1 : 0;

        if ( (left + right + mid) >= 2 )
            this.TNode = midNode;

        return (left + right + mid) > 0 ? 1 : 0;
    }

}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

