package duant.lock;

import duant.Enum.EnumTest;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: duant
 * @Date: 2019/12/31 13:48
 * 闭锁
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 离开 ");
                countDownLatch.countDown();
            },EnumTest.forEachEnum(i).getMsg()).start();
        }
        countDownLatch.await();
        System.out.println(" 全部离开 ");
    }

}
