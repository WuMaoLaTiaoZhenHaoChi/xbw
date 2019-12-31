package leetcode.month09;

/**
 * @Author: DuanTong
 * @Date: 2019/9/11 14:36
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 */
public class Solution0911 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0){
            nums1[p--] = nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2,0,nums1,0,p2 + 1);
    }

    /*public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);

        int p1 = 0;
        int p2 = 0;

        int index = 0;

        while ((p1 < m) && (p2 < n)){
            if (nums1_copy[p1] <= nums2[p2])
                nums1[index++] = nums1_copy[p1++];
            else
                nums1[index++] = nums2[p2++];
        }
        if (p1 < m)
            System.arraycopy(nums1_copy,p1,nums1,p1 + p2,n + m - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2,p2,nums1,p1 + p2,m + n - p1 - p2);

    }*/

/*    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }*/

    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> allList = new ArrayList<>();
        for (int i = 0;i < m ;i++){
            if (i < m)
                allList.add(nums1[i]);
            if (i < n)
                allList.add(nums2[i]);
        }
        Collections.sort(allList);
        for (int i = 0;i < m + n;i++)
            nums1[i] = allList.get(i);
    }*/
}
