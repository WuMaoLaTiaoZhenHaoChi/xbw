package leetcode.month08;

/**
 * @Author: DuanTong
 * @Date: 2019/8/16 17:12
 */
public class Solution0816 {

    public static void main(String[] args) {
        int[] nums = {8, 8, 7, 7, 7};
        Solution0816 s = new Solution0816();
        System.out.println(s.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {

        int length = nums.length;
        for (int i = 0; i < length / 2 + 1; i++) {
            int count = 0;
            for (int num : nums) {
                if (nums[i] == num)
                    count++;
            }
            if (count > length / 2)
                return nums[i];
        }
        return -1;
    }

}
