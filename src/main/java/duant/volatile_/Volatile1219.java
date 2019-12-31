package duant.volatile_;

/**
 * @Author: duant
 * @Date: 2019/12/19 9:49
 */
public class Volatile1219 {

    private static Volatile1219 volatile1219 = null;

    private Volatile1219(){
        System.out.println(" Volatile1219 的构造器 ");
    }

    //单例模式不安全问题
    public static Volatile1219 getInstance(){
        if (null == volatile1219){
            volatile1219 = new Volatile1219();
        }
        return volatile1219;
    }

/*    public static Volatile1219 getInstance(){
        if (null == volatile1219){
            synchronized (volatile1219){
                if (volatile1219 == null){
                    volatile1219 = new Volatile1219();
                }
            }
        }
        return volatile1219;
    }*/

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " start ");
                Volatile1219.getInstance();
            },"Thread" + i).start();
        }
    }
}
