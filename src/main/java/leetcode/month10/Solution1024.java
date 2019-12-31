package leetcode.month10;

/**
 * @Author: DuanTong
 * @Date: 2019/10/24 14:41
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class Solution1024 {
    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }

    public static int numTrees(int n) {
        long C = 1;
        for (int i = 0;i < n;i++){
            C = C * (4 * i + 2) / (i + 2);
        }
        return (int) C;
    }

/*    public static int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2;i <= n;i++){
            for (int j = 1;j <= i;j++){
                nums[i] += nums[j - 1] * nums[i - j];
            }

        }
        return nums[n];
    }*/
}
