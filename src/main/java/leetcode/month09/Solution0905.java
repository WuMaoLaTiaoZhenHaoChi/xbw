package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/5 17:27
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票
 *
 */
public class Solution0905 {

    public static void main(String[] args) {
        int[] prices = {7,4,4,9,1};
        System.out.println(maxProfit1(prices));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int left = 0,right = prices.length - 1;
        for (left = 0; left < right;left++){
            for (right = right; right > left; right--){
                max = Math.max(max,prices[right] - prices[left]);
            }
        }
        return max > 0 ? max : 0;
    }

    public static int maxProfit1(int[] prices) {
        if (prices.length == 0)
            return 0;
        int maxP = 0;
        int minP = prices[0];
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < minP)
                minP = prices[i];
            maxP = Math.max(prices[i] - minP,maxP);
        }
        return maxP;

    }



}
