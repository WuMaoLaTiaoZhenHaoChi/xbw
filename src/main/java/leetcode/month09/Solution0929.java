package leetcode.month09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/9/29 10:59
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 */
public class Solution0929 {

    public static void main(String[] args) {
        Solution0929 s = new Solution0929();
        int[] nums = {1,2,3,4};
        System.out.println(s.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        if (nums.length == 0)
            return retList;
        List<Integer> numList = new ArrayList<>();
        for (int num : nums)
            numList.add(num);
        addList(0,numList.size(),numList,retList);
        return retList;
    }

    public void addList(int start,int length,List<Integer> numList,List<List<Integer>> retList){
        if (start == length)
            retList.add(new ArrayList<>(numList));

        for (int i = start;i < length;i++){
            Collections.swap(numList,start,i);
            addList(start + 1,length,numList,retList);
            Collections.swap(numList,start,i);
        }

    }

}
