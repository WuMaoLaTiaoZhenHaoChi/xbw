package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/28 15:12
 *
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 */
public class Solution0928 {

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483646"));
    }

    public static int myAtoi(String str) {
        long retNum = 0;
        int start = 0,first = 1;
        str = str.trim();
        if (str.length() == 0)
            return 0;
        if (str.charAt(0) == '-'){
            first = -1;
            start++;
        }
        if (str.charAt(0) == '+')
            start ++;


        for (int i = start;i < str.length();i++){
            Character c = str.charAt(i);
            if (!Character.isDigit(c))
                break;
            retNum = retNum * 10 + c - '0';
            if (retNum * first >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (retNum * first <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int)retNum * first;
    }
}
