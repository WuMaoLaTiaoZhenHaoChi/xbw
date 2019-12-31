package mode.Decorator;

/**
 * @Author: DuanTong
 * @Date: 2019/8/27 17:22
 */
public class Source implements Sourceable {

    public Source() {
        System.out.println("Source constructor");
    }

    @Override
    public void method() {
        System.out.println("this is my method");
    }

}
