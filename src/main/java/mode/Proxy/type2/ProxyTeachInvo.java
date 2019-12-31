package mode.Proxy.type2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: DuanTong
 * @Date: 2019/10/22 16:11
 */
public class ProxyTeachInvo {

    private Object target;

    public ProxyTeachInvo(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(" 动态代理开始 ---");
                Object retObj = method.invoke(target,args);
                System.out.println(" 动态代理结束 ---");
                return retObj;
            }
        });
    }
}
