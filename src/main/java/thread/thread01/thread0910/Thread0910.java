package thread.thread01.thread0910;

/**
 * @Author: DuanTong
 * @Date: 2019/9/10 21:24
 */
public class Thread0910 {

    public static void main(String[] args) {

        Thread t = new MyThread091001("AA");

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();

    }

}


class MyThread091001 extends Thread {

    public MyThread091001(String name) {
        this.setName(name);
    }

    private int count = 5;

    @Override
    synchronized public void run() {
        if (count > 0) {
            count--;
            System.out.println("Thread--->" + Thread.currentThread().getName() + " 计算，剩余： " + count);

        }

        /*while (count > 0){
            synchronized (this){
                count --;
                System.out.println("Thread--->" + Thread.currentThread().getName()  + " 计算，剩余： " + count);
            }
        }*/
    }
}