package leetcode.month09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/9/1 16:46
 */
public class Solution0901 {

    public static void main(String[] args) {
        Solution0901 s = new Solution0901();

        ListNode head = new ListNode(6);
        ListNode next2 = new ListNode(6);
        ListNode next3 = new ListNode(11);
        ListNode next4 = new ListNode(9);
        next3.next = next4;
        next2.next = next3;
        head.next = next2;
        ListNode retNode =  s.sortList(head);;
        System.out.println(retNode);

    }

    /**
     *在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
     */
    public ListNode sortList(ListNode head) {
        List<Integer> list =  sort(head);
        return listToNode(list);
    }

    public List<Integer> sort(ListNode head){
        List<Integer> nodeList = new ArrayList<Integer>();
        while (head != null){
            nodeList.add(head.val);
            head = head.next;
        }
        Collections.sort(nodeList);
        return nodeList;
    }

    public ListNode listToNode(List<Integer> list){
        if (list.isEmpty())
            return null;
        ListNode node = new ListNode(list.get(0));
        node.next = listToNode(list.subList(1,list.size()));
        return node;
    }


}
