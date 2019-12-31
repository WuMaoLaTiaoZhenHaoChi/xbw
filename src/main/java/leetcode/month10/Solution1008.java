package leetcode.month10;

/**
 * @Author: DuanTong
 * @Date: 2019/10/8 14:39
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Solution1008 {

    public static void main(String[] args) {
        Solution1008 s = new Solution1008();
        System.out.println(s.multiply("11","11"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] strs = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1;i >= 0;i--){
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1;j >= 0;j--){
                int n2 = num2.charAt(j) - '0';
                int sum = strs[i + j + 1] + n1 * n2;
                strs[i + j + 1] = sum % 10;
                strs[i + j] += sum / 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < strs.length;i++){
            if (i == 0 && strs[i] == 0)
                continue;
            stringBuilder.append(strs[i] + "");
        }
        return stringBuilder.toString();
    }

}
