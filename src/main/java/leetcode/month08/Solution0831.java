package leetcode.month08;

/**
 * @Author: DuanTong
 * @Date: 2019/8/31 15:47
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class Solution0831 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(singleNumber(nums));
    }


/*    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int countNums = 0;
        int countSet = 0;
        for (int num : nums) {
            countNums += num;
            set.add(num);
        }
        for (int num : set){
            countSet += num;
        }
        return countSet * 2 - countNums;
    }*/

    public static int singleNumber(int[] nums) {

        for (int i = 0;i < nums.length;i++){
            int count = 0;
            for (int j = 0;j < nums.length;j++){
                count = nums[i] == nums[j] ? count + 1 : count;
            }
            if (count == 1)
                return nums[i];
        }
        return 0;
    }


}
