package leetcode.month08;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/8/26 15:22
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 */
public class Solution0826 {

    public static void main(String[] args) {
        Solution0826 s = new Solution0826();
        int[] nums = {1,2,3};
        List<List<Integer>> lists = s.subsets(nums);
        for (List<Integer> list : lists ) {
            System.out.println(list);
        }
    }


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();

        resultList.add(new ArrayList<Integer>());
        for (int n : nums){
            int size = resultList.size();
            for (int j = 0; j < size; j++){
                List<Integer> sonList = new ArrayList<>(resultList.get(j));
                sonList.add(n);
                resultList.add(sonList);
            }

        }
        return resultList;
    }

}
