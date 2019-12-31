package mode.flyweight.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/21 10:23
 */
public class Client {

    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight flyweight1 = flyweightFactory.getFlyweight("微博");
        flyweight1.user(new User("tom"));

        Flyweight flyweight2 = flyweightFactory.getFlyweight("QQ");
        flyweight2.user(new User("bob"));

        System.out.println(flyweightFactory.getCount());
    }
}
