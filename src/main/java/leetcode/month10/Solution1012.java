package leetcode.month10;

/**
 * @Author: DuanTong
 * @Date: 2019/10/12 16:18
 */
public class Solution1012 {

    public static void main(String[] args) {
        int[] nums = {3};
        //System.out.println(Arrays.toString(fraction(nums)));
    }

    public static int[] fraction(int[] cont) {
        if (cont.length == 0)
            return new int[]{0,0};
        int[] retNum = new int[2];
        int numerator = cont[cont.length - 1], denominator = 1;
        for (int i = cont.length - 2;i >= 0;i --){
            int temp = denominator;
            denominator = numerator;
            numerator = temp;

            numerator += denominator * cont[i];
        }
        retNum[0] = numerator;
        retNum[1] = denominator;
        return retNum;
    }

}
