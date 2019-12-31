package leetcode.month08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DuanTong
 * @Date: 2019/8/15 15:48
 */
public class Solution0815 {

    public static void main(String[] args) {
        int[] nums = {1, 8, 8, 11, 3, 24, 3, 2, 35, 10};
/*        boolean b = containsDuplicate(nums);
        System.out.println(b);*/
        Solution0815 s = new Solution0815();
        System.out.println(s.findKthLargest(nums,3));
        System.out.print(Arrays.toString(nums));

    }


    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     *
     * @param node
     */

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> mapNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mapNums.put(nums[i], i);
        }
        return (mapNums.size() < nums.length);
    }


    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     */
    public int findKthLargest(int[] nums,int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    void quickSort(int[] nums, int left, int right) {

        if (left < right){
            int i = left, j = right, temp = nums[i];
            while (i < j) {

                while (temp > nums[j] && i < j) {
                    j--;
                }
                if (i < j)
                    nums[i++] = nums[j];

                while (temp < nums[i] && i < j) {
                    i++;
                }
                if (i < j)
                    nums[j--] = nums[i];
            }
            nums[i] = temp;
            quickSort(nums,left,i - 1);
            quickSort(nums,i + 1,right);
        }
    }

}
