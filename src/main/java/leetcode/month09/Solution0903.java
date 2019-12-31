package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/3 14:43
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution0903 {


/*    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return sortList(l1,l2);
    }

    public ListNode sortList(ListNode l1,ListNode l2){
        List<Integer> listAll = new ArrayList<>();
        while (l1 != null){
            listAll.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            listAll.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(listAll);
        return listToNode(listAll);
    }
    public ListNode listToNode(List<Integer> list){
        if (list.size() == 0)
            return null;
        ListNode node = new ListNode(list.get(0));
        node.next = listToNode(list.subList(1,list.size()));
        return node;
    }*/
    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

}
