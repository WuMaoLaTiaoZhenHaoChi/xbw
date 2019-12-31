package mode.visitor.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/25 10:13
 */
public abstract class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract void accept(Action visitor);


}
