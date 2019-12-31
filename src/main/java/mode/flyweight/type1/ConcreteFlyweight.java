package mode.flyweight.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/21 10:15
 */
public class ConcreteFlyweight extends Flyweight {
    private String type;

    public ConcreteFlyweight(String type) {
        this.type = type;
    }

    @Override
    public void user(User user) {
        System.out.println(user.getName() + " 使用 " + getType());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
