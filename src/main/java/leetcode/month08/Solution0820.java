package leetcode.month08;

/**
 * @Author: DuanTong
 * @Date: 2019/8/20 16:55
 */
public class Solution0820 {

    public static void main(String[] args) {
        Solution0820 s = new Solution0820();
        System.out.println(s.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        String str = "";
        String strRet = "";
        for (int i = 0; i < s.length(); i ++){
            int left = i - 1;
            int right = i + 1;
            int middle = i;
            int tempL = 1,tempR = 0;
            while (left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    str = s.substring(left,right + 1);
                    left--;
                    right++;
                }
                else
                    break;
            }
            strRet = strRet.length() < str.length() ? str : "".equals(strRet) ? s.substring(0,1) : strRet;
            while ( (middle - tempL) >= 0 && (middle + tempR) < s.length()) {
                if(s.charAt(middle - tempL) == s.charAt(middle + tempR)){
                    str = s.substring(middle - tempL,middle + tempR + 1);
                    tempL ++;
                    tempR ++;
                }
                else
                    break;
            }
            strRet = strRet.length() < str.length() ? str : "".equals(strRet) ? s.substring(0,1) : strRet;
        }
        return strRet;
    }

}
