package leetcode.month11;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: 小霸王
 * @Date: 2019/11/7 15:15
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Solution1107 {

    public static void main(String[] args) {
        Solution1107 s = new Solution1107();
        int[] ints = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString( s.dailyTemperatures(ints)));
    }

    public int[] dailyTemperatures(int[] T) {
        int[] retT = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        int len = T.length;
        for (int i = len - 1; i >= 0 ; i--) {
            while (!stack.empty() && T[i] >= T[stack.peek()])
                stack.pop();
            retT[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return retT;
    }

    /*public int[] dailyTemperatures(int[] T) {
        int[] retT = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int count = 0;
            for (int j = i + 1; j <= T.length; j++) {
                count ++;
                if (j == T.length){
                    count = 0;
                    break;
                }
                if (T[j] > T[i])
                    break;
            }
            retT[i] = count;
        }
        return retT;
    }*/
}
