package mode.adapter.type2;

/**
 * @Author: DuanTong
 * @Date: 2019/10/12 15:47
 */
public class Phone {

    public void charge(Voltage5 voltage5){
        int src = voltage5.outV5();
        if (src == 5)
            System.out.println(" 电压为5V，可以正常充电 ");
        else
            System.out.println(" 电压不等于5V，不能充电 ");
    }

}
