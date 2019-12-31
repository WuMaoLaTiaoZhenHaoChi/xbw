package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/25 14:57
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */
public class Solution0925 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int tempNext = 0;
        ListNode resultNode = new ListNode(0);
        ListNode node1 = l1,node2 = l2,retNode = resultNode;
        while (node1 != null || node2 != null){
            int val1 = node1 == null ? 0 : node1.val;
            int val2 = node2 == null ? 0 : node2.val;

            int temp = val1 + val2 + tempNext;
            tempNext = temp / 10;

            retNode.next = new ListNode(temp % 10);
            retNode = retNode.next;

            if (node1 != null)
                node1 = node1.next;
            if (node2 != null)
                node2 = node2.next;
        }

        if (tempNext == 1)
            retNode.next = new ListNode(1);
        return resultNode.next;
    }

}
