package JUC.juc1114;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: 小霸王
 * @Date: 2019/11/14 14:11
 *
 * 闭锁
 */
public class JUC111403 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        MyThread myThread = new MyThread(latch);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(myThread," A" + i).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
        }
        long end = System.currentTimeMillis();
        System.out.println(" 时间间隔 " + (end - start));
    }

}


class MyThread implements Runnable{

    private CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + " num = " + i);
            }
        }finally {
            latch.countDown();
        }
    }
}