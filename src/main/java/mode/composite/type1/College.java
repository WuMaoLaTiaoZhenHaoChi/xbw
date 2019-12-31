package mode.composite.type1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/10/17 10:30
 */
public class College extends Composition {

    List<Composition> compositions = new ArrayList<>();

    public College(String des, String name) {
        super(des, name);
    }

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
