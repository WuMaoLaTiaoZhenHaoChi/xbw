package leetcode.month08;

/**
 * @Author: DuanTong
 * @Date: 2019/8/10 15:01
 */
public class Solution0810 {




    public static String reverseWords(String s) {
/*        String retStr = "";
        if (s != null){
            String[] str = s.split(" ");
            for(int i = 0;i < str.length;i++){
                String str1 = str[i];
                str1 = new StringBuilder(str1).reverse().toString();
                retStr += (i == str.length - 1) ?  str1 : str1 + " ";
            }
            return retStr;
        }
        return null;*/
//        StringBuilder strB = new StringBuilder();
//        if (s != null){
//            String[] strs = s.split(" ");
//            for(int i = 0;i < strs.length;i++){
//                StringBuilder str = new StringBuilder();
//                str.append(strs[i]);
//                strB.append(str.reverse().toString()).append(" ");
//            }
//            return strB.substring(0,strB.length() - 1);
//        }
//        return null;
        StringBuilder strB = new StringBuilder();
        if (s != null) {
            String[] strs = s.split(" ");
            for (int i = 0; i < strs.length; i++) {
                StringBuilder str = new StringBuilder();
                str.append(strs[i]);
                strB.append(str.reverse().toString()).append(" ");
            }
            return strB.substring(0, strB.length() - 1);
        }
        return null;
    }

    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * <p>
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * <p>
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * <p>
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * <p>
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * <p>
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     *
     * @param str
     * @return
     */

    public static int myAtoi(String str) {
        if (str == null)
            return 0;
        String str1 = "";
        char c;
        int retNum;
        int fuhao = 0;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if ( (c < '0' || c > '9') && (c != '-' && c != '+' && c != ' ') ) {
                break;
            }else {
                if (c == ' ')
                    continue;
                if (c == '+' || c == '-') {
                    fuhao++;
                }
                if (fuhao > 1)
                    break;
                if (fuhao < 1) {
                    str1 += c;
                }else
                    str1 += c;

            }
        }
        //str1 = str1.concat("").substring(1,str1.concat("").length());
        str1 = ( "".equals(str1) || str1.equals("-") || str1.equals("+") || str1.length() > 11 ) ? "0"  : str1;
/*        if ( str1.indexOf("+") != -1)
            str1 = str1.substring(str1.indexOf("+"));
        else if ( str1.indexOf("-") != -1){
            str1 = str1.substring(str1.indexOf("-"));
        }*/
        return  Long.parseLong(str1) > Integer.MAX_VALUE || Long.parseLong(str1) < Integer.MIN_VALUE ?
                Long.parseLong(str1) > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.MIN_VALUE : Integer.parseInt(str1);
    }


    public static void main(String[] args) {
        //System.out.println(reverseWords("Let's take LeetCode contest"));

        System.out.println(myAtoi("123-123-123"));
    }
}
