package leetcode.month11;

/**
 * @Author: 小霸王
 * @Date: 2019/11/13 15:02
 */
public class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0,curr = 0;
        int p2 = nums.length - 1;

        while (curr <= p2){
            if (nums[curr] == 0){
                nums[curr] = nums[p0];
                nums[p0 ++] = 0;
            } else if (nums[curr] == 2){
                nums[curr++] = nums[p2];
                nums[p2 --] = 2;
            }
            else
                curr ++;
        }
    }
}
