package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/30 9:26
 */
public class Solution0930{

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB){
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? nodeA : nodeB.next;
        }
        return nodeA;
    }



}

    /*private int val;
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        findNode(root,k);
        return val;
    }

    public void findNode(TreeNode node,int k){
        if (node == null)
            return;
        findNode(node.left,k);
        if (++count == k)
          val = node.val;
        findNode(node.right,k);
    }*/