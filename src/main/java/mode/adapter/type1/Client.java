package mode.adapter.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/12 15:36
 */
public class Client {

    public static void main(String[] args) {
        Voltage5 voltage5 = new VoltageAdapter();
        Phone p = new Phone();
        p.charge(voltage5);
    }

}
