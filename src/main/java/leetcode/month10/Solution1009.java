package leetcode.month10;

/**
 * @Author: DuanTong
 * @Date: 2019/10/9 14:38
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 */
public class Solution1009 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode[] nodes = {node1,node1};
        mergeKLists(nodes);

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode retNode = new ListNode(0);

        return retNode;
    }

    /*public static ListNode mergeKLists(ListNode[] lists) {

        ListNode retNode = new ListNode(0);
        List<Integer> valList = new ArrayList<>();
        for (ListNode node : lists){
            while (node != null){
                valList.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(valList);
        if (valList.size() > 0){
            //retNode = new ListNode(valList.get(0));
            ListNode node = retNode;
            for (int i = 1;i < valList.size();i++){
                node.next = new ListNode(valList.get(i));
                node = node.next;
            }
        }
        return retNode.next;
    }*/


    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode retNode = new ListNode(-1);
        ListNode tempNode = retNode;
        while (l1 != null || l2 != null){
            if (l1.val <= l2.val){
                tempNode.next = l1;
                l1 = l1.next;
            }else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        tempNode.next = l1 == null ? l2 : l1;
        return retNode.next;
    }

/*    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode retNode = null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return retNode = l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return retNode = l2;
        }
    }*/

}
