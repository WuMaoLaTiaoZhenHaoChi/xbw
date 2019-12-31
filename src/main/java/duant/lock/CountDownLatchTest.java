package duant.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: duant
 * @Date: 2019/12/31 13:48
 * 闭锁
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(() -> {
                System.out.println(" t " + num + "离开");
                countDownLatch.countDown();
            },"Thread - " + i).start();
        }
        countDownLatch.await();
        System.out.println(" 全部离开 ");
    }

}
