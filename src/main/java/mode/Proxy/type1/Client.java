package mode.Proxy.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/22 16:09
 */
public class Client {

    public static void main(String[] args) {
        TeachImpl teach = new TeachDao();
        ProxyTeach proxyTeach = new ProxyTeach(teach);//静态代理
        proxyTeach.teschProxy();
    }

}
