package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/7 14:56
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 *
 */
public class Solution0907 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(maxProfit(arr));
    }

    /*public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int buy = prices[0],sell = prices.length;
        int maxP = 0;
        int index = 0;
        while (index < prices.length - 1){
            while (index < prices.length - 1 && prices[index + 1] <= prices[index])
                index++;
            buy = index;

            while (index  < prices.length - 1 && prices[index + 1] >= prices[index])
                index++;
            sell = index;
            maxP += prices[sell] - prices[buy];
        }
        return maxP;
    }*/

    public static int maxProfit(int[] prices) {

        int maxP = 0;
        for (int i = 1; i < prices.length;i++){
            if (prices[i] > prices[i - 1])
                maxP += prices[i] - prices[i - 1];
        }
        return maxP;
    }

}
