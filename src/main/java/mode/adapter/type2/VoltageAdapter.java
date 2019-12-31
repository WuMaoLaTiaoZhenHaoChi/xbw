package mode.adapter.type2;

/**
 * @Author: DuanTong
 * @Date: 2019/10/12 15:45
 */
public class VoltageAdapter implements Voltage5 {

    private Voltage220 voltage220;

    public VoltageAdapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int outV5() {
        int src = voltage220.outV220();
        System.out.println(" 现在220V电压 ");
        src /= 44;
        System.out.println(" 转换为5V电压  ");
        return src;
    }

}
