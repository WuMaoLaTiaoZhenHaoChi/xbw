package mode.singleton.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/9/27 9:24
 *
 * 饿汉式
 */
public class Singleton01 {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);
    }

}

class Singleton{

    private final static Singleton singleton;

    static {
        singleton = new Singleton();
    }

    private Singleton(){

    }

    public static Singleton getInstance(){
        return singleton;
    }
}

/*class Singleton{

    private final static Singleton SINGLETON = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return singleton;
    }
}*/

