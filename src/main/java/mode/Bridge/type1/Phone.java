package mode.Bridge.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/15 14:14
 */
public abstract class Phone {

    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open(){
        brand.open();
    }

    protected void call(){
        brand.call();
    }

    protected void close(){
        brand.close();
    }

}
