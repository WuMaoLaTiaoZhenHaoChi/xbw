package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/23 16:30
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class Solution0923 {

    public static void main(String[] args) {
        Solution0923 s = new Solution0923();
        int[] nums = {3,5,6,7,8,9};
        System.out.println(s.search(nums,5));
    }

    public int search(int[] nums, int target) {

       return findIndex(nums,target);
    }

    public int findIndex(int nums[],int target){

        int left = 0,right = nums.length - 1;
        int retIndex = -1;
        while (left <= right){
            retIndex = (left + right) / 2;
            if (nums[retIndex] == target)
                return retIndex;
            else if (nums[retIndex] < target)
                left = retIndex + 1;
            else  if(nums[retIndex] > target)
                right = retIndex - 1;
        }
        return -1;
    }


/*
    public static int search(int[] nums, int target) {
        List<Integer> numList = new ArrayList<Integer>();
        for (int num : nums)
            numList.add(num);
        return numList.contains(target) ? numList.indexOf(target) : -1;
    }
*/

}
