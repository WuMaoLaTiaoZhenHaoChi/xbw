package mode.memento.type1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DuanTong
 * @Date: 2019/10/30 21:20
 */
public class Caretaker {

    private Map<Integer, Memento> mementoMap = new HashMap<>();

    public void addMenento(int index, Memento memento){
        mementoMap.put(index,memento);
    }

    public Memento getMenento(int index){
        return mementoMap.get(index);
    }
}
