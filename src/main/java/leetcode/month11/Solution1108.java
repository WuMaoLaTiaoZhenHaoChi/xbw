package leetcode.month11;

import java.util.Arrays;

/**
 * @Author: 小霸王
 * @Date: 2019/11/08 15:05
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class Solution1108 {

    public static void main(String[] args) {
        Solution1108 s = new Solution1108();
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(s.minDistance(str1,str2));
    }

    public int minDistance(String word1, String word2) {
        int count = 0;
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] ints = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            ints[i][0] = ints[i - 1][0] + 1;
        }
        for (int j = 1; j <= length2; j++) {
            ints[0][j] = ints[0][j - 1] + 1;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2 ; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    ints[i][j] = ints[i - 1][j - 1];
                else
                    ints[i][j] = Math.min(Math.min(ints[i - 1][j],ints[i][j - 1]),ints[i - 1][j - 1]) + 1;
            }
        }
        System.out.println("--------------");
        for (int[] intarr : ints){
            System.out.println(Arrays.toString(intarr));
        }
        System.out.println("--------------");
        count = ints[length1][length2];
        return count;
    }
}
