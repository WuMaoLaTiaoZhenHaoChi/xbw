package thread.thread01.thread0916;

/**
 * @Author: DuanTong
 * @Date: 2019/9/16 22:01
 */
public class MyThread2 {

    public static void main(String[] args) throws InterruptedException {
/*        MyThread091602 r02 = new MyThread091602();
        r02.start();
        Thread.sleep(1000);
        r02.interrupt();*/
        Thread.currentThread().interrupt();
        System.out.println("是否中断01 " + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("是否中断02 " + Thread.interrupted());
    }

}

class MyThread091602 extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0;i < 100;i++){
            System.out.println("i = " + (i + 1));
        }

    }
}
