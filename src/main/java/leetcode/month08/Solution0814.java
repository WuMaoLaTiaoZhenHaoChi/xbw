package leetcode.month08;

import java.util.Arrays;

/**
 * @Author: DuanTong
 * @Date: 2019/8/14 14:05
 */
public class Solution0814 {

    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] output = productExceptSelf(nums);
        System.out.printf(Arrays.toString(output));
    }

    /**
     *
     * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * @param nums
     * @return
     */
/*    public static int[] productExceptSelf1(int[] nums) {
        int index = nums.length - 1;
        if (index < 0)
            return null;
        int[] output = new int[index + 1];
        int result = 1;
        for(int i = 0;i <= index;i++){
            if (nums[i] != 0)
                result *= nums[i];
        }
        for (int i = 0;i <= index;i++){
            output[i] = result / (nums[i] == 0 ? 1 : nums[i]);
        }
        return output;
    }*/

    public static int[] productExceptSelf(int[] nums) {
        int index = nums.length;
        if (index <= 0)
            return null;
        int[] output = new int[index];
        int k = 1;
        for (int i = 0; i < index; i++){
            output[i] = k;
            k *= nums[i];
        }

        int l = 1;
        for (int i = index - 1; i >= 0; i--){
            output[i] *= l;
            l *= nums[i];
        }
        return output;
    }




}
