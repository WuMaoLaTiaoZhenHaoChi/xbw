package duant.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: duant
 * @Date: 2020/01/02 8:47
 * 栅栏
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println(" 集齐七颗龙珠 ");
        });

        for (int i = 0; i < 7; i++) {
            final int num = i;
            new Thread(() -> {
                try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + " 收集第 " + num + " 龙珠 ");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"Thread - " + i).start();
        }

    }

}
