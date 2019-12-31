package leetcode.month08;

/**
 * @Author: DuanTong
 * @Date: 2019/8/8 15:01
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 */
public class Solution0808 {

    public static void main(String[] args) {
            System.out.println("return" + reverse(10000000));
    }

    public static int reverse(int x) {
        int retNum = 0;

        while (x != 0){
            int num = x % 10;
            x /= 10;
            retNum =retNum * 10 + num;
        }

        return retNum;
    }

}
