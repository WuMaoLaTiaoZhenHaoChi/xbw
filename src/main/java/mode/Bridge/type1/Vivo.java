package mode.Bridge.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/15 14:12
 */
public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println(" Vivo手机开机 ");
    }

    @Override
    public void call() {
        System.out.println(" Vivo手机打电话 ");
    }

    @Override
    public void close() {
        System.out.println(" Vivo手机关机 ");
    }
}
