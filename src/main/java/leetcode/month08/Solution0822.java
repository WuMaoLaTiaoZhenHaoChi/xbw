package leetcode.month08;

/**
 * @Author: DuanTong
 * @Date: 2019/8/22 11:10
 */
public class Solution0822 {

    public static void main(String[] args) {
        Solution0822 s = new Solution0822();
        int[] flowerbed = {0,0,0};
        int n = 2;
        System.out.println(s.canPlaceFlowers(flowerbed,n));
    }


    /**
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     *
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int index1 = -2;

        for (int i = 0; i < flowerbed.length; i++){
            if (flowerbed[i] == 1){
                int num = (i - index1 - 2) / 2;
                count += num > 0 ? num : 0;
                index1 = i;
            }
        }
        count += (flowerbed.length - 1 - index1) / 2;

        return count >= n;
    }

}

