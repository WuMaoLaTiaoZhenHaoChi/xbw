package leetcode.month10;

import java.util.Arrays;

/**
 * @Author: DuanTong
 * @Date: 2019/10/11 15:48
 */
public class Solution1010 {

    public static void main(String[] args) {
        Solution1010 s = new Solution1010();
        int[] nums = {65,72,75,80,85,60,55,50,45};
        System.out.println(Arrays.toString(s.quickSort(nums)));
    }

    public int[] quickSort(int[] nums){
        if (nums.length < 0)
            return nums;
        quick(nums,0,nums.length - 1);
        return nums;
    }

    public void quick(int[] nums,int start,int end){
        int num = nums[start];
        int left = start,right = end;
        while (left < right){
            if (nums[left] < num){
                left ++;
            }
            if (nums[right] > num){
                right --;
            }
             else {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        if (left - 1 > start)
            quick(nums,start,left - 1);
        if (right + 1 < end)
            quick(nums,right + 1,end);
    }

}
