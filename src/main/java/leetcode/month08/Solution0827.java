package leetcode.month08;

import java.util.Arrays;

/**
 * @Author: DuanTong
 * @Date: 2019/8/27 10:27
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class Solution0827 {

    public static void main(String[] args) {
        Solution0827 s = new Solution0827();
        int[][] nums = s.generateMatrix(4);
        for (int[] num:nums) {

            System.out.println(Arrays.toString(num));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int up = n - 1,right = n - 1,down = 0,left = 0;
        int count = n * n;
        int num = 1;
        while (num <= count){
            for (int i = down;i <= up;i++)
                nums[left][i] = num++;
            left++;

            for (int i = left;i <= right;i++)
                nums[i][up] = num++;
            up--;

            for (int i = up;i >= down;i--)
                nums[right][i] = num++;
            right--;

            for (int i = right;i >= left;i--)
                nums[i][down] = num++;
            down++;
        }

        return nums;
    }

}
