package leetcode.month08;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/8/29 14:44
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 */
public class Solution0829 {

    public static void main(String[] args) {
        List<Integer> list = grayCode(0);
        System.out.println(list);
    }

    public static List<Integer> grayCode(int n) {

        List<Integer> retList = new ArrayList<Integer>();
        //添加默认第一个0
        retList.add(0);

        //循环增加
        for (int i = 0;i < n;i++){
            //每次循环在前面加1
            int addNum = 1 << i;
            //倒序添加进去就ok了
            for (int j = retList.size() - 1;j >= 0;j--){
                retList.add(addNum + retList.get(j));
            }

        }
        return retList;
    }

}
