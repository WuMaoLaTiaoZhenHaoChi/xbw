package mode.Factory.type1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DuanTong
 * @Date: 2019/9/30 14:35
 */
public class TestType1 {

    @Test
    public void test1(){
        PizzaFactory factory = new PizzaFactory();
        Pizza pizza = factory.getPizza("A");
        Map<String,String> map = new HashMap<>();
        map.put("张三","20");
    }

}
