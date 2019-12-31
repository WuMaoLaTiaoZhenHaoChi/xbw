package leetcode.month11;

/**
 * @Author: 小霸王
 * @Date: 2019/11/25 16:39
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution1125 {

    public int trap(int[] height) {
        int sum = 0;
        int left_index = 0,right_index = height.length - 1;
        int max_left = 0,max_right = 0;
        while (left_index < right_index){
            if (height[left_index] < height[right_index]){
                if (height[left_index] >= max_left)
                    max_left = height[left_index];
                else
                    sum += (max_left - height[left_index]);
                left_index ++;
            }else {
                if (height[right_index] > max_right)
                    max_right = height[right_index];
                else
                    sum += max_right - height[right_index];
                right_index --;
            }
        }
        return sum;
    }

/*    public int trap(int[] height) {
        int sum = 0,size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0,max_right = 0;
            for (int j = 0; j <= i; j++) {
                max_left = Math.max(height[j],max_left);
            }
            for (int j = i; j < size - 1; j++) {
                max_right = Math.max(height[j],max_right);
            }
            sum += Math.min(max_left,max_right) - height[i];
        }
        return sum;
    }*/

}
