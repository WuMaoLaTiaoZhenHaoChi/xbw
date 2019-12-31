package leetcode.month09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/9/24 16:39
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class Solution0924 {

    public static void main(String[] args) {
        Solution0924 s = new Solution0924();
        int[] nums1 = {};
        int[] nums2 = {3,4};
        System.out.println(s.findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        List<Integer> numsList = new ArrayList<Integer>();
        for (int num1 : nums1)
            numsList.add(num1);
        for (int num2 : nums2)
            numsList.add(num2);
        Collections.sort(numsList);
        return length % 2 == 0 ? ((double) numsList.get(length / 2 - 1) + (double)numsList.get(length / 2)) / 2 : (double)numsList.get(length / 2);
    }

}
