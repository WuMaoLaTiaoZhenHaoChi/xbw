package duant.volatile_;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: duant
 * @Date: 2019/12/18 13:51
 */
public class Volatile1218 {

    private volatile int num = 0;
    //private int num = 0;

    public void setNum() {
        num = num + 60;
    }

    //可见性验证
    @Test
    public void test1() {
        // Volatile1218 v = new Volatile1218();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setNum();
            System.out.println(Thread.currentThread().getName() + "\t" + "num值已经被更改为：" + num);
        }, "Thread-1").start();

        while (0 == num) {

        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }

    //--------------------------------

    //不保证原子性验证
    private volatile int num2 = 0;

    public void addNum(){
        num2 ++;
    }

    //不保证原子性
    @Test
    public void test2(){
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    addNum();
                }
            },"Thread" + i).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " num " + num2);
    }

    private AtomicInteger atomicInteger = new AtomicInteger();

    //使用Atomic可保证
    @Test
    public void test3(){
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.getAndIncrement();
                }
            },"Thread" + i).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " num " + atomicInteger);
    }


}
