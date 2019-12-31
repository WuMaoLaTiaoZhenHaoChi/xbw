package leetcode.month09;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: DuanTong
 * @Date: 2019/9/17 15:22
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 */
public class Solution0917 {

    private Map<Character,Character> charMap;

    public Solution0917() {
        this.charMap = new HashMap<Character, Character>();
        charMap.put(')','(');
        charMap.put(']','[');
        charMap.put('}','{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if (charMap.containsKey(c)){
                char valueChar = stack.empty() ? '*' : stack.pop();
                if (valueChar != charMap.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution0917 s = new Solution0917();
        System.out.println(s.isValid("()[]{}"));
    }

}
