package mode.Bridge.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/15 14:20
 */
public class StraightPhone extends Phone {

    public StraightPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void open() {
        System.out.println(" 直板手机 ");
        super.open();
    }

    @Override
    protected void call() {
        System.out.println(" 直板手机 ");
        super.call();
    }

    @Override
    protected void close() {
        System.out.println(" 直板手机 ");
        super.close();
    }
}
