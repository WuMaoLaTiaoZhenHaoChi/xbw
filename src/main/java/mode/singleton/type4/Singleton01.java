package mode.singleton.type4;

/**
 * @Author: DuanTong
 * @Date: 2019/9/27 9:24
 *
 * 懒汉式
 */
public class Singleton01 {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);

        System.out.println("singleton1 : " + singleton1.hashCode());
        System.out.println("singleton2 : " + singleton2.hashCode());
    }

}

class Singleton{

    private Singleton(){}

    static class SingletonInstance{
        private final static Singleton SINGLETON = new Singleton();

    }

    public static Singleton getInstance() {
        return SingletonInstance.SINGLETON;
    }

}



