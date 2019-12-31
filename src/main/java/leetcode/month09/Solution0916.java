package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/16 14:18
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 */
public class Solution0916 {

    public boolean hasCycle(ListNode head) {
        ListNode quickNode = head;
        ListNode slowNode = head;

        while (quickNode != null && quickNode.next != null){
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if (quickNode == slowNode)
                return true;
        }
        return false;

    }

/*    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null){
            nodeSet.add(head);
            head = head.next;
            if (nodeSet.contains(head))
                return true;
        }
        return false;
    }*/

}
