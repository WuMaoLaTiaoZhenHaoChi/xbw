package mode.adapter.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/12 15:30
 */
public class VoltageAdapter extends Voltage220 implements Voltage5 {

    @Override
    public int getVoltage5() {
        int src = getVoltage220();
        System.out.println(" 拿到220V电压 ");
        src /= 44;
        System.out.println(" 转换为5V电压  ");
        return src;
    }

}
