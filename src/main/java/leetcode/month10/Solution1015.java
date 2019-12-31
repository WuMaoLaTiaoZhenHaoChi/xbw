package leetcode.month10;

import java.util.Arrays;

/**
 * @Author: DuanTong
 * @Date: 2019/10/15 14:41
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 */
public class Solution1015 {

    public static void main(String[] args) {
        Solution1015 s = new Solution1015();
        System.out.println(Arrays.toString(s.countBits(8)));
        //System.out.println(s.count(7));
    }

    public int[] countBits(int num) {
        int[] ints = new int[num + 1];
        for (int i = 1;i <= num;i++){
            if (i % 2 == 0)
                ints[i] = ints[i >> 1];
            if (i % 2 == 1)
                ints[i] = ints[i >> 1] + 1;
        }
        return ints;
    }

/*    public int[] countBits(int num) {
        int[] ints = new int[num + 1];
        for (int i = 1;i <= num;i++){
            ints[i] = ints[i & (i - 1)] + 1;
        }
        return ints;
    }*/

    //计算全部
//    public int[] countBits(int num) {
//        int[] ints = new int[num + 1];
//        for (int i =0;i <= num;i++){
//            ints[i] = count(i);
//        }
//        return ints;
//    }
//
    //分别计算每个数字中1的位数
//    public int count(int num){
//        int sum = 0;
//        while (num > 0){
//            if (num % 2 == 1)
//                sum += 1;
//            num = num >> 1;
//        }
//        return sum;
//    }

}
