package mode.singleton.type2;

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

    private static Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        synchronized(Singleton.class){
            if (singleton == null){
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}

/*class Singleton{

    private static Singleton singleton;
    private Singleton(){}
    synchronized public static Singleton getInstance(){
        if (singleton == null)
            singleton = new Singleton();
        return singleton;
    }
}*/


