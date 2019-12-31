package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/4 15:39
 */
public class Solution0904 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome1(1221));
        String str = "2142  1421@qq .com;21  4214@qq.com=we  wqijewqje@qq.com+";
        String matchs = "^[0-9a-zA-Z.@]+$";
        str.matches(matchs);
        System.out.println(str);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String xStr = x + "";
        for (int i = 0,j = xStr.length() - 1;i < xStr.length() && j >= 0;i++,j--){
            char left = xStr.charAt(i);
            char right = xStr.charAt(j);
            if (left != right)
                return false;
        }
        return true;
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0 || (x  % 10 == 0 || x != 0) )
            return false;
        int resverNum = 0;
        while (x > resverNum){
            resverNum = resverNum * 10 + x % 10;
            x /= 10;
        }
        return x == resverNum || x == resverNum / 10;
    }

}
