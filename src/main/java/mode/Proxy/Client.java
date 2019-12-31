package mode.Proxy;

import mode.Proxy.type1.TeachDao;
import mode.Proxy.type1.TeachImpl;
import mode.Proxy.type2.ProxyTeachInvo;

/**
 * @Author: DuanTong
 * @Date: 2019/10/22 16:09
 */
public class Client {

    public static void main(String[] args) {
        TeachImpl teach = new TeachDao();
        //ProxyTeach proxyTeach = new ProxyTeach(teach);静态代理
        //proxyTeach.teschProxy();
        TeachDao teach2 = new TeachDao();
        TeachDao teachDao  = (TeachDao) new ProxyTeachInvo(teach2).getProxyInstance();
        teach2.teach1();
    }

}
