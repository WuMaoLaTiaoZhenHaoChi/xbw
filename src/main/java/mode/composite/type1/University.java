package mode.composite.type1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/10/17 10:26
 */
public class University extends Composition {

    List<Composition> compositions = new ArrayList<>();

    public University(String des, String name) {
        super(des, name);
    }

/*    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public String getName() {
        return super.getName();
    }*/

    @Override
    protected void add(Composition composition) {
        compositions.add(composition);
    }

    @Override
    protected void remove(Composition composition) {
        compositions.remove(composition);
    }

    @Override
    protected void print() {
        System.out.println("---------" + this.getName() + " " + this.getDes() + "---------");
        for (Composition composition:compositions) {
            composition.print();
        }
    }
}
