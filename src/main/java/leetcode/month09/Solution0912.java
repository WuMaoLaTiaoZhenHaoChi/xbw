package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/12 16:02

给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class Solution0912 {

    public ListNode detectCycle(ListNode head) {
        if (isCycle(head) == null)
            return null;
        ListNode retNode = isCycle(head);
        while (true){
            if (head == retNode)
                return head;
            head = head.next;
            retNode = retNode.next;
        }
    }

    public ListNode isCycle(ListNode head){
        ListNode slow = head;
        ListNode quick = head;

        while (quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if (quick == slow)
                return quick;
        }
        return null;

    }

/*    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();

        while (head != null){
            nodeSet.add(head);
            head = head.next;
            if (nodeSet.contains(head))
                return head;
        }

        return null;
    }*/

}
