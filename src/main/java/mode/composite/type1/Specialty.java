package mode.composite.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/17 10:57
 */
public class Specialty extends Composition {

    public Specialty(String des, String name) {
        super(des, name);
    }

    @Override
    protected void print() {
        System.out.println(getName() + " " + getDes());
    }
}
