package leetcode.month08;

import java.util.Arrays;

/**
 * @Author: DuanTong
 * @Date: 2019/8/12 16:36
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class Solution0812 {

    public static void main(String[] args) {
        //System.out.println(isPowerOfTwo(0));
        Solution0812 s = new Solution0812();
        char[] c = {'B','a','n','n','C','a','h'};
        s.reverseString(c);
    }


    public static boolean isPowerOfTwo(int n) {

        boolean b = false;
        if (n == 1 || n < 0) return true;
        for (int i = 0; i <= 32; i++){
            if ( 2 << i == n && 2 << i < n )
                return  true;
        }
        return false;
    }


    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * @param s
     */
    public void reverseString(char[] s) {
        /*System.out.printf("[");
        for(int i = s.length - 1;i >= 0;i--){
            System.out.printf( "\"" + s[i] + "\"");
        }
        System.out.printf("]");*/
        int j = s.length -1;
        for (int i = 0;i < s.length / 2; i++){
            char c = s[j];
            s[j] = s[i];
            s[i] = c;
            j --;
        }
        System.out.printf(Arrays.toString(s));
    }

    void swap(int begin,int end,char[] s){

        char c;
        if (begin <= end){
            c = s[end];
            s[end--] = s[begin];
            s[begin++] = c;
            swap(begin,end,s);
        }

    }

}
