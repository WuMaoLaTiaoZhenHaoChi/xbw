package leetcode.month08;

/**
 * @Author: DuanTong
 * @Date: 2019/8/6 15:27
 */
public class Solution0806 {

    public static void main(String[] args) {
        String[] strs = {"aaawwwabbb", "aaawwwccc", "aaawwwvbbb"};
        String str = longestCommonPrefix(strs);
        System.out.println("返回相同前缀字符串：" + str);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";
        int longStr = 0;
        int index = 0;
        String returnStr = "";
        boolean tip = true;
        //选择最长字符串
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < longStr) {
                longStr = strs[i].length();
                index = i;
            }
        }

        String str = strs[index];
        //从头开始判断，是否相等
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < strs.length; j++)
                if (!strs[j].startsWith(str.substring(0, i + 1))) {
                    tip = false;
                    break;
                }
            returnStr = tip ? str.substring(0, i + 1) : returnStr;
        }
        return returnStr;
    }
}

