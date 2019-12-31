package mode.visitor.type1;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/10/25 10:24
 */
public class ObjectStructure {

    List<Person> personList = new LinkedList<>();

    //添加
    public void attach(Person person){
        personList.add(person);
    }

    //去掉
    public void detach(Person person){
        personList.remove(person);
    }

    //打印结果
    public void display(Action action){
        for (Person person : personList) {
            person.accept(action);
        }
    }

}
