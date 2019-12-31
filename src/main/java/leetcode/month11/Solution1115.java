package leetcode.month11;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 小霸王
 * @Date: 2019/11/15 15:28
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Solution1115 {
    public static void main(String[] args) {
        Solution1115 s = new Solution1115();
        List<String> stringList = s.letterCombinations("");
        System.out.println(stringList);
    }

    String[] strings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> outList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0){
            helper("",digits);
        }
        return outList;
    }

    public void helper(String str1,String str2){
        if (str2.length() <= 0){
            outList.add(str1);
            return;
        }else{
            String head_str = str1;
            String next_str = strings[Integer.parseInt(str2.substring(0,1))];
            for (int i = 0; i < next_str.length(); i++) {
                head_str =str1 + next_str.substring(i,i + 1);
                helper(head_str,str2.substring(1));
            }
        }
    }
}
