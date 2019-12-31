package mode.adapter.type2;

/**
 * @Author: DuanTong
 * @Date: 2019/10/12 15:49
 */
public class Client {

    public static void main(String[] args) {
        Phone p = new Phone();
        Voltage220 voltage220 = new Voltage220();
        Voltage5 voltage5 = new VoltageAdapter(voltage220);
        p.charge(voltage5);
    }

}
