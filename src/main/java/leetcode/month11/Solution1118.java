package leetcode.month11;

/**
 * @Author: 小霸王
 * @Date: 2019/11/18 15:09
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
public class Solution1118 {

    public static void main(String[] args) {
        Solution1118 s = new Solution1118();
        int n = s.numSquares(4);
        System.out.println(n);
    }
    int[] ints;
/*    public int numSquares(int n) {
        ints = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ints[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                ints[i] = Math.min(ints[i],ints[i - j * j] + 1);
            }
        }
        return ints[n];
    }*/

    public int numSquares(int n) {
        ints = new int[n + 1];
        return helper(n);
    }

    public int helper(int n){
        if ( ints[n] != 0){
            return ints[n];
        }
        int v = (int) Math.sqrt(n);
        if (v * v == n){
            return ints[n] = 1;
        }
        int temp = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            temp = Math.min(Integer.MAX_VALUE,helper(i));
        }
        return ints[n] = temp;
    }

}
