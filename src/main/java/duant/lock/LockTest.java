package duant.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: duant
 * @Date: 2020/01/03 16:35
 */
public class LockTest {
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private int num = 0;

    public void put() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0){
                condition.await();
            }
            condition.signalAll();
            System.out.println(Thread.currentThread().getName() + " 生产之后库存 " + ++num);
        } finally {
            lock.unlock();
        }

    }

    public void get() throws InterruptedException {
        lock.lock();
        try {
            while (num <= 0){
                condition.await();
            }
            condition.signalAll();
            System.out.println(Thread.currentThread().getName() + " 消费之后库存 " + --num);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 5; j++) {
                        lockTest.put();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"Tread - " + i).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 5; j++) {
                        lockTest.get();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"Tread - " + i).start();
        }

    }

}
