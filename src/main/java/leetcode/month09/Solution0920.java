package leetcode.month09;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/9/20 14:51
 */
public class Solution0920 {

    public static void main(String[] args) {
        int[][] matrix = {

        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> matrixList = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0)
            return matrixList;
        int n = matrix[0].length;
        int up = n - 1, right = m - 1, down = 0, left = 0;

        while (matrixList.size() < m * n) {
            for (int i = down; i <= up && (matrixList.size() < m * n); i++) {
                matrixList.add(matrix[left][i]);
            }
            left++;

            for (int i = left; i <= right && (matrixList.size() < m * n); i++) {
                matrixList.add(matrix[i][up]);
            }
            up--;

            for (int i = up; i >= down && (matrixList.size() < m * n); i--) {
                matrixList.add(matrix[right][i]);
            }
            right--;

            for (int i = right; i >= left && (matrixList.size() < m * n); i--) {
                matrixList.add(matrix[i][down]);
            }
            down++;
        }
        return matrixList;
    }

}
