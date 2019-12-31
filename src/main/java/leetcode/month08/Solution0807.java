package leetcode.month08;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/8/7 16:04
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 */
public class Solution0807 {

    public static void main(String[] args) {

/*        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();*/
        List<String> list = fizzBuzz(15);
        System.out.println("{");
        for (String str:list) {
            System.out.println(str + ",");
        }
        System.out.println("}");

    }

    public static List<String> fizzBuzz(int n){

        String str = "";
        List<String> list =  new ArrayList<>();
        for (int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                str = "FizzBuzz";
            }else{
                str = i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : Integer.toString(i);
            }
            list.add(str);
        }

        return list;
    }

}
