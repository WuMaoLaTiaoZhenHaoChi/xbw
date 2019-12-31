package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/18 17:12
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class Solution0918 {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return null;
        else if (head.next == null || k == 0)
            return head;
        ListNode retNode;
        ListNode deptNode = head;
        int countNode = 1;
        while (deptNode.next != null){
            countNode ++;
            deptNode = deptNode.next;
        }
        deptNode.next = head;
        k = k % countNode;
        ListNode endNode = head;
        for (int i =0;i < countNode - k - 1;i++){
            endNode = endNode.next;
        }
        retNode = endNode.next;
        endNode.next = null;
        return retNode;
    }

}
