package leetcode.month11;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 小霸王
 * @Date: 2019/11/12 15:00
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 */
public class Solution1112 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        Solution1112 s = new Solution1112();
        System.out.println(s.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> retList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]){
                swap(nums,nums[i] - 1,i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1){
                retList.add(i + 1);
            }
        }
        return retList;
    }

    public void swap(int[] nums,int index1,int index2){
        if (index1 == index2)
            return;
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }
}
