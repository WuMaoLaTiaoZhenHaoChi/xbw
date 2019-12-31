package leetcode.month09;

import java.util.Arrays;

/**
 * @Author: DuanTong
 * @Date: 2019/9/15 14:39
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 */
public class Solution0915 {

    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(nums,-1));
    }


    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minNum = nums[0] + nums[1] + nums[2];
        for (int i = 0;i < nums.length;i++){
            int start = i + 1,end = nums.length - 1;
            while (start < end){
                int temp = nums[start] + nums[end] + nums[i];
                /*if (Math.abs(target - temp) <= Math.abs(target - minCount))
                    minCount = temp;*/
                if (temp <  target)
                    start ++;
                else if (temp > target)
                    end --;
                else
                    return target;
                minNum = Math.abs(minNum - target) <= Math.abs(temp - target) ? minNum : temp;
            }
        }
        return minNum;
    }


    /*public static int threeSumClosest(int[] nums, int target) {
        int minNum = Integer.MAX_VALUE;
        for (int i = 0;i < nums.length - 2;i++){
            for (int j = i + 1;j < nums.length - 1;j++){
                for (int k = j + 1;k < nums.length;k++){
                    int num = nums[i] + nums[j] + nums[k] - target;
                    minNum = Math.abs(minNum) <= Math.abs(num) ? minNum : num;
                }
            }
        }
        return minNum + target;
    }*/

}
