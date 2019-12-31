package leetcode.month11;

import java.util.*;

/**
 * @Author: 小霸王
 * @Date: 2019/11/1 16:21
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class Solution1101 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numMap = new HashMap<>();
        List<Integer> retList = new LinkedList<>();
        for (int n : nums){
            numMap.put(n,numMap.getOrDefault(n,0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((n1,n2) -> numMap.get(n1) - numMap.get(n2));
        for (int n : numMap.keySet()){
            priorityQueue.add(n);
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }

        while (!priorityQueue.isEmpty()){
            retList.add(priorityQueue.poll());
        }
        Collections.reverse(retList);
        return retList;
    }
}
