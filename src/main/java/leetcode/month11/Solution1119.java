package leetcode.month11;

/**
 * @Author: 小霸王
 * @Date: 2019/11/19 16:14
 * <p>
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
 */
public class Solution1119 {

    public static void main(String[] args) {
        Solution1119 s = new Solution1119();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(s.maxProfit1(prices));
        System.out.println(s.maxProfit(prices));
    }

    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            if (i == 1){
                dp[i][0] = Math.max(dp[0][0], dp[0][1] + prices[i]);
                dp[i][1] = Math.max(dp[0][1],-prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 2][0] -prices[i]);
        }
        return dp[n - 1][0];
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_0 = 0,dp_1 = Integer.MIN_VALUE;
        int dp_pre = 0;
        for (int i = 0; i < n; i++) {
            int temp = dp_0;
            dp_0 = Math.max(dp_0,dp_1 + prices[i]);
            dp_1 = Math.max(dp_1,dp_pre - prices[i]);
            dp_pre = temp;
        }
        return dp_0;
    }

}
