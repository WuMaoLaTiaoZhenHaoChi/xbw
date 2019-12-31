package mode.Proxy.type2;

/**
 * @Author: DuanTong
 * @Date: 2019/10/22 16:35
 */
public class Client {
    public static void main(String[] args) {
        TeachDao target = new TeachDao();
        //TeachDao proxyInstance = (TeachDao) new ProxyTeachInvo(target).getProxyInstance();
        Teach proxyInstance = (Teach) new ProxyTeachInvo(target).getProxyInstance();
        proxyInstance.teach1();
    }
}
