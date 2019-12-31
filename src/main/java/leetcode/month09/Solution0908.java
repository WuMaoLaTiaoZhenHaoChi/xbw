package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/8 20:38
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 */
public class Solution0908 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int count = 0;
        int maxSub = nums[0];
        for (int i = 0;i < nums.length;i++){
            if (count > 0)
                count += nums[i];
            else
                count = nums[i];
            maxSub = Math.max(count,maxSub);
        }
        return maxSub;
    }

}
