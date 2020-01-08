package duant.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @Author: duant
 * @Date: 2019/12/25 9:38
 */
public class ListTest1225 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,6));
                System.out.println(list);
            },"Thread" + i).start();
        }
    }

}
