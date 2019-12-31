package leetcode.month11;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 小霸王
 * @Date: 2019/11/29 16:53
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 */
public class Solution1129 {

    public static void main(String[] args) {
        Solution1129 s = new Solution1129();
        System.out.println(s.decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        Map<Integer, String> map = helper(s);
        StringBuilder stringBuilder = new StringBuilder();
        for (int key : map.keySet()){
            for (int i = 0; i < key; i++) {
                stringBuilder.append(map.get(key));
            }
        }
        return stringBuilder.toString();
    }
    
    public Map<Integer,String> helper(String str){
        Map<Integer,String> retMap = new HashMap<>();
        int key_index = 0, val_left = 0, val_right = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '['){
                val_left = i;
            }else if (c == ']'){
                val_right = i ;
                retMap.put(Integer.parseInt(str.substring(key_index,val_left)),
                        str.substring(val_left + 1,val_right));
                key_index = val_right + 1;
            }

        }
        return retMap;
    }
}
