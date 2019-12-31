package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/9 14:41
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数
 */
public class Solution0909 {

    public static void main(String[] args) {
        Solution0909 s = new Solution0909();
        System.out.println(s.climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int[] sum = new int[n + 1];
        sum[1] = 1;
        sum[2] = 2;
        for (int i = 3; i <= n;i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[n];
    }

   /* public int climbStairs(int n) {
        int[] count = new int[n + 1];
        return sum(0,n,count);
    }

    public int sum(int now,int n,int[] nums){
        if (now > n)
            return 0;
        if (now == n)
            return 1;
        nums[now] = sum(now + 1,n,nums) +
                sum(now + 2,n,nums);
        return nums[now];
    }*/

}
