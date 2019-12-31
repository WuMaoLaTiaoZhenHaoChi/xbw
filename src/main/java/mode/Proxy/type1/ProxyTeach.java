package mode.Proxy.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/22 16:07
 * 静态代理
 */
public class ProxyTeach {

    private TeachImpl teach;

    public ProxyTeach(TeachImpl teach) {
        this.teach = teach;
    }

    public void teschProxy(){
        System.out.println(" 代理开始--- ");
        teach.teach1();
        System.out.println(" 代理结束--- ");
    }
}
