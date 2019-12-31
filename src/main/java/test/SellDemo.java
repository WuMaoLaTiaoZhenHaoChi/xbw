package test;

/**
 * @Author: DuanTong
 * @Date: 2019/9/7 10:02
 */
public class SellDemo {

    public static void main(String[] args) {
        Runnable s = new Sell();

        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);
        Thread t4 = new Thread(s);
        Thread t5 = new Thread(s);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }


}


class Sell implements Runnable {

    private static int ticket = 500;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余票数：" + --ticket);
                } else {
                    System.out.println("票已售完！");
                    break;
                }
            }
        }
    }

}
