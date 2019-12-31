package mode.Bridge.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/15 14:21
 */
public class Cilent {

    public static void main(String[] args) {
        Brand brand = new XiaoMi();
        Phone phone1 = new StraightPhone(brand);

        phone1.open();
        phone1.call();
        phone1.close();
        System.out.println("-----------");

        Brand brand1 = new Vivo();
        Phone phone2 = new StraightPhone(brand1);
        phone2.open();
        phone2.call();
        phone2.close();

        Phone phone3 = new FolePhone(brand1);
        phone3.open();
        phone3.call();
        phone3.close();

    }

}
