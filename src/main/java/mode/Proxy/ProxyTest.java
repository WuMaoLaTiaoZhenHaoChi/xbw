package mode.Proxy;

import mode.Decorator.Sourceable;
import org.junit.Test;

/**
 * @Author: DuanTong
 * @Date: 2019/8/28 19:40
 */

public class ProxyTest {

    @Test
    public void test(){

        Sourceable sourceable = new Proxy();
        sourceable.method();

    }

}
