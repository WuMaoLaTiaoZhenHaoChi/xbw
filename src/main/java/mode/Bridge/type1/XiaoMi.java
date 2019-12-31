package mode.Bridge.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/15 14:11
 */
public class XiaoMi implements Brand {
    @Override
    public void open() {
        System.out.println(" 小米手机开机 ");
    }

    @Override
    public void call() {
        System.out.println(" 小米手机打电话 ");
    }

    @Override
    public void close() {
        System.out.println(" 小米手机关机 ");
    }
}
