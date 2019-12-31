package mode.flyweight.type1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DuanTong
 * @Date: 2019/10/21 10:13
 *
 * 享元模式
 */
public class FlyweightFactory {

    Map<String, Flyweight> flyweightMap = new HashMap();

    public Flyweight getFlyweight(String type) {
        if (!flyweightMap.containsKey(type)){
            flyweightMap.put(type,new ConcreteFlyweight(type));
        }
        return flyweightMap.get(type);
    }

    public int getCount(){
        return flyweightMap.size();
    }

}
