package leetcode.month10;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 16:30
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
public class Solution1028 {

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            if (set.contains(i))
                return nums[i];
            set.add(i);
        }
        return 0;
    }
}
