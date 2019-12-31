package mode.adapter.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/12 15:33
 */
public class Phone {

    public void charge(Voltage5 voltage5){

        if (voltage5.getVoltage5() == 5){
            System.out.println(" 电压为5V，可以正常充电 ");
        }else if (voltage5.getVoltage5() > 5){
            System.out.println(" 电压过大，无法充电！");
        }
    }

}
