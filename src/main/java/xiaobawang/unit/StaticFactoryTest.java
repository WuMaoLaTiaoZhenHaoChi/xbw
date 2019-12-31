package xiaobawang.unit;


import org.junit.Test;
import xiaobawang.factory.Sender;
import xiaobawang.factory.moreStaticFactory02.StaticFactory;

/**
 * @Author: DuanTong
 * @Date: 2019/7/28 10:53
 */
public class StaticFactoryTest {

    @Test
    public void staticFactory(){
        Sender sender = StaticFactory.productMail();
        sender.send();
    }

}
