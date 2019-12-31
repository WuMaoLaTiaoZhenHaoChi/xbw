package leetcode.month11;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 小霸王
 * @Date: 2019/11/6 15:18
 *
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 */
public class Solution1106 {

    public static void main(String[] args) {
        Solution1106 s = new Solution1106();
        int[] nums = {9,76,64,21,97,60};
        System.out.println(s.maxCoins(nums));
    }

    public int maxCoins(int[] nums) {
        int length = nums.length;
        int  sum = 0;
        if (length < 1)
            return sum;
        if (length == 1)
            return nums[0];
        sum = (Math.min(nums[0],nums[length - 1]) + 1) * Math.max(nums[0],nums[length - 1]);
        List<Integer> numList = new LinkedList<>();
        for (int num : nums)
            numList.add(num);
        for (int i = 1; i < numList.size() - 1;) {
            int index = 1;
            for (int j = 1; j < numList.size() - 1; j++) {
                if (numList.get(i) > numList.get(j))
                    index = j;
            }
            int left = numList.get(index - 1);
            int right = numList.get(index + 1);

            sum += left * numList.get(index) * right;
            numList.remove(index);
        }
        return sum;
    }
}
