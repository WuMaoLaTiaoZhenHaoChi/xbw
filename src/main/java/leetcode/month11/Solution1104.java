package leetcode.month11;

import java.util.Arrays;

/**
 * @Author: 小霸王
 * @Date: 2019/11/4 14:46
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Solution1104 {
    public static void main(String[] args) {
        Solution1104 s = new Solution1104();
        int nums[] = {0, 1, 0, 3, 12, 0, 0, 123};
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                if (i != j){
                    nums[j] = nums[i];
                }
                j ++;
            }
        }

        for (;j < nums.length;j++){
            nums[j] = 0;
        }
    }
}
