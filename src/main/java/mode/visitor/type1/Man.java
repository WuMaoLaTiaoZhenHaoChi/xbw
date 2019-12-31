package mode.visitor.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/25 10:11
 */
public class Man extends Person {

    public Man(String name) {
        super(name);
    }

    @Override
    public void accept(Action visitor) {
        visitor.getManGrade(this);
    }
}
