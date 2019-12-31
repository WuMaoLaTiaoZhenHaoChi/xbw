package leetcode.month10;

import java.util.*;

/**
 * @Author: DuanTong
 * @Date: 2019/10/30 15:19
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class Solution1030 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new ArrayList<List<String>>();
        lists = groupAnagrams(strs);
        for (List list:lists){
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> retMap = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!retMap.containsKey(key))
                retMap.put(key,new ArrayList());
            retMap.get(key).add(str);
        }
        return new ArrayList(retMap.values());
    }
}
