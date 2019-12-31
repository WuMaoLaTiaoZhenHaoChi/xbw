package duant.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: duant
 * @Date: 2019/12/25 9:34
 */
public class AtomicTest1125 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        AtomicStampedReference stampedReference = new AtomicStampedReference(100,1);
        new Thread(() -> {
            boolean b0 = atomicInteger.compareAndSet(100, 101);
            System.out.println(Thread.currentThread().getName() + atomicInteger.get() + b0);

            boolean b1 = atomicInteger.compareAndSet(101, 100);
            System.out.println(Thread.currentThread().getName() + atomicInteger.get() + b1);

        }," Thread-A ").start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b2 = atomicInteger.compareAndSet(100, 103);
            System.out.println(Thread.currentThread().getName() + atomicInteger.get() + b2);

        }," Thread-B ").start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b3 = stampedReference.compareAndSet(100, 101,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + stampedReference.getReference() + b3);

            boolean b4 = stampedReference.compareAndSet(101, 100,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + stampedReference.getReference() + b4);
        }," Thread-C ").start();

        new Thread(() -> {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b5 = stampedReference.compareAndSet(100, 101,
                    1, 2);
            System.out.println(Thread.currentThread().getName() + stampedReference.getReference() + b5);
        }," Thread-C ").start();
    }

}
