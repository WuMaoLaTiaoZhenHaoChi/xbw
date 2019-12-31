package thread.thread01.thread0916;

/**
 * @Author: DuanTong
 * @Date: 2019/9/16 21:25
 */
public class MyThread1 {

    public static void main(String[] args) {
        MyThread091601 r1 = new MyThread091601();
        System.out.println("begin" + System.currentTimeMillis());
        //r1.run();
        r1.start();
        System.out.println("end" + System.currentTimeMillis());
    }

}

class MyThread091601 extends Thread{

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + " ----> begin" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + " ----> end" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
