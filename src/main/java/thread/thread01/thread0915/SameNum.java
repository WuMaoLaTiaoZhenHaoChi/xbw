package thread.thread01.thread0915;

/**
 * @Author: DuanTong
 * @Date: 2019/9/15 10:10
 */
public class SameNum {

    public static void main(String[] args) {
        MyThread run = new MyThread();

        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        Thread t4 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}

class MyThread extends Thread{

    private int i = 5;
    private int t = 5;



    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": ---->  i=" + i--);
    }
}