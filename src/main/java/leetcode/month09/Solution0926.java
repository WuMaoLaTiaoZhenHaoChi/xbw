package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/26 15:53
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Solution0926 {

    public static void main(String[] args) {
        System.out.println(reverse(-123634));
    }

    public static int reverse(int x) {
        int retNum = 0;
        while (x != 0){
            int temp = x % 10;
            x /= 10;

            if (retNum > Integer.MAX_VALUE / 10 || (retNum == Integer.MAX_VALUE / 10 && temp > 7))
                return 0;
            if (retNum < Integer.MIN_VALUE / 10 || (retNum == Integer.MIN_VALUE / 10 && temp < -8))
                return 0;
            retNum = retNum * 10 + temp;
        }
        return retNum;
    }

}
