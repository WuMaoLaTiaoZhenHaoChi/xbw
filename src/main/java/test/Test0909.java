package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/9/9 11:23
 */
public class Test0909 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < 10;i++){
            list.add(i);
        }

        for(int num : list)
            System.out.print(num + " ");
    }

}

class A{
    private int a = 1;

}
