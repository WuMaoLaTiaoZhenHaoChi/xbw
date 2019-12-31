package leetcode.month10;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: DuanTong
 * @Date: 2019/10/25 16:58
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 */
public class Solution1025 {

    public static void main(String[] args) {
        Solution1025 s = new Solution1025();
        System.out.println();
    }

    public int[][] reconstructQueue(int[][] people) {
/*        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });*/
        Arrays.sort(people,(o1,o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0] );
        LinkedList<int[]> lists = new LinkedList<>();
        for (int[] arr : people){
            lists.add(arr[1],arr);
        }
        return lists.toArray(new int[lists.size()][2]);
    }
}
