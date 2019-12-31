package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/2 16:14
 */
public class Solution0902 {

    public static void main(String[] args) {
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(maxArea2(height));
    }

    public static int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++){
            for (int j = i + 1; j < height.length; j++){
                int minHeight = height[i] <= height[j] ? height[i] : height[j];
                int area = (j - i) * minHeight;
                maxArea = maxArea >= area ? maxArea : area;
            }

        }
        return maxArea;
    }

    public static int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0,right = height.length - 1;
        while (left < right){
            maxArea = Math.max(maxArea,(right - left) * Math.min(height[left],height[right]));
            if (height[left] < height[right])
                left ++;
            else
                right --;
        }
        return maxArea;
    }

}
