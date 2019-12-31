package leetcode.month10;

import java.util.Arrays;

/**
 * @Author: DuanTong
 * @Date: 2019/10/23 16:43
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 */
public class Solution1023 {

    public static void main(String[] args) {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        Solution1023 s = new Solution1023();
        s.rotate(nums);
        for (int[] num : nums)
            System.out.println(Arrays.toString(num));
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0;i < len;i++){
            for (int j = i;j < len;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0;i < len;i++){
            for (int j = 0;j < len / 2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }
    }
}
