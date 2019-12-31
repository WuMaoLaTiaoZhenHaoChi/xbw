package leetcode.month11;

/**
 * @Author: 小霸王
 * @Date: 2019/11/3 17:49
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 */
public class Solution1103 {
    public static void main(String[] args) {
        Solution1103 s = new Solution1103();
        int count = s.countSubstrings("aaa");
        System.out.println(count);
    }

    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += countHuiwen(s,i,i);
            result += countHuiwen(s,i,i+1);
        }
        return result;
    }

    public int countHuiwen(String s,int left,int right){
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)){
            count ++;
        }
        return count;
    }
}
