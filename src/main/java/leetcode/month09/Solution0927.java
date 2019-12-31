package leetcode.month09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/9/27 14:55
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 */
public class Solution0927 {

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 2;i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1,k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0){
                    while (j < k && nums[j] == nums[++j]);
                }else if (sum > 0){
                    while (j < k && nums[k] == nums[--k]);
                }else{
                    retList.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while (j < k && nums[j] == nums[++j]);
                    while (j < k && nums[k] == nums[--k]);
                }
            }

        }
        return retList;
    }

}

/*    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        if (nums.length < 3)
            return retList;
        for (int i = 0;i < nums.length - 2;i++){
            for (int j = i + 1;j < nums.length - 1;j++){
                for (int k = j + 1;k < nums.length;k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> tempList = new ArrayList<Integer>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        Collections.sort(tempList);
                        if (!retList.contains(tempList))
                            retList.add(tempList);
                    }
                }
            }
        }
        return retList;
    }*/
