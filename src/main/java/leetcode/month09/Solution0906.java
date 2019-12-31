package leetcode.month09;

import java.util.Arrays;

/**
 * @Author: DuanTong
 * @Date: 2019/9/6 16:50
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多,少条不同的路径？
 *
 */
public class Solution0906 {

    public static void main(String[] args) {
        int x = uniquePaths(3,2);
        System.out.println(x);
    }

    public static int uniquePaths(int m, int n) {
        /*int[][] paths = new int[m][n];
        for (int i = 0;i < m;i++)
            paths[i][0] = 1;
        for (int i = 0;i < n;i++)
            paths[0][i] = 1;
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
            }
        }
        return paths[m - 1][n - 1];*/

        int[] paths = new int[n];
        Arrays.fill(paths,1);
        paths[0] = 1;
        for(int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                paths[j] += paths[j - 1];
            }
        }

        return paths[n - 1];
    }

}
