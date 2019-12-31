package duant.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: duant
 * @Date: 2019/12/30 15:26
 * 自旋锁
 */
public class SpinLockTest {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        System.out.println(Thread.currentThread().getName() +" 进入MyLock ");
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)){

        }

    }

    public void myUnLock(){
        System.out.println(Thread.currentThread().getName() +" 释放MyLock ");
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        SpinLockTest spinLock = new SpinLockTest();
        new Thread(() -> {
            spinLock.myLock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.myUnLock();
        },"Thread-A").start();

        new Thread(() -> {
            spinLock.myLock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.myUnLock();
        },"Thread-B").start();

    }

}
