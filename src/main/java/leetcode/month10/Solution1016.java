package leetcode.month10;

/**
 * @Author: DuanTong
 * @Date: 2019/10/16 16:11
 */
public class Solution1016 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(93,73));
    }

    public static int hammingDistance(int x, int y) {
        int ret = 0;
        while (x > 0 || y > 0){
            if ((x & 1) != (y & 1))
                ret ++;
            x >>= 1;
            y >>= 1;
        }
        return ret;
    }

/*    public static int hammingDistance(int x, int y) {
        int ret = 0;
        int temp = x ^ y;
        while (temp > 0){
            ret = temp % 2 == 1 ? ret + 1 : ret;
            temp = temp >> 1;
        }
        return ret;
    }*/
}
