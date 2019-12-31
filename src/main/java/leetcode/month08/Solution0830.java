package leetcode.month08;

/**
 * @Author: DuanTong
 * @Date: 2019/8/30 16:32
 *
 * 反转一个单链表。
 */
public class Solution0830 {

/*    public ListNode reverseList(ListNode head) {
        ListNode retNode = null;
        ListNode tempNode = head;
        //判断链表是否已经反转完毕
        while (tempNode != null){
            ListNode temp = tempNode.next;
            tempNode.next = retNode;
            retNode = tempNode;
            tempNode = temp;
        }
        return retNode;
    }*/

    public static void main(String[] args) {
        ListNode next1 = new ListNode(3);
        ListNode next2 = new ListNode(6);
        ListNode next3 = new ListNode(8);
        ListNode next4 = new ListNode(9);
        next3.next = next4;
        next2.next = next3;
        next1.next = next2;
        ListNode retNode = reverseList(next1);
        System.out.println(retNode);

    }

    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode retNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return retNode;
    }

}
