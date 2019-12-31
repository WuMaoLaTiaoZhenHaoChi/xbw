package mode.Decorator;

import org.junit.Test;

/**
 * @Author: DuanTong
 * @Date: 2019/8/27 17:28
 */

public class DecoratorTest {

    @Test
    public void test1(){
        Source source = new Source();
        Sourceable decorator = new Decorator(source);
        decorator.method();
    }

}
