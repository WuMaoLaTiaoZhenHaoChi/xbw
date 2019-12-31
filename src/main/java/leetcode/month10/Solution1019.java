package leetcode.month10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/10/19 14:49
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 */
public class Solution1019 {

    public static void main(String[] args) {
        Solution1019 s = new Solution1019();
        int[] nums = {2,3,5};
        //System.out.println(s.combinationSum(nums,7));
        System.out.println(s.combinationSum2(nums,8));
    }

    List<List<Integer>> retList = new ArrayList<>();
    int[] candidates;



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        combination2(target,0,0,new ArrayList<>());
        return retList;
    }
    public void combination2(int target,int sum,int start,List<Integer> nums){
        if (sum == target){
            retList.add(new ArrayList<>(nums));
            return;
        }
        for (int i = start;i < candidates.length && sum + candidates[i] <= target;i++){
            nums.add(candidates[i]);
            combination2(target,sum + candidates[i],i,nums);
            nums.remove(nums.size() - 1);
        }
    }

/*    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        combination(target,0,new ArrayList<>());
        return retList;
    }

    public void combination(int target,int start,List<Integer> nums){
        if (target == 0){
            retList.add(new ArrayList<>(nums));
            return;
        }
        for (int i = start;i < candidates.length && target - candidates[i] >= 0;i++){
            nums.add(candidates[i]);
            combination(target - candidates[i],i,nums);
            nums.remove(nums.size() - 1);
        }
    }*/

}
