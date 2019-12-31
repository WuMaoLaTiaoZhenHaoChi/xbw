package mode.visitor.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/25 10:12
 */
public class Woman extends Person {
    public Woman(String name) {
        super(name);
    }

    @Override
    public void accept(Action visitor) {
        visitor.getWomanGrade(this);
    }
}
