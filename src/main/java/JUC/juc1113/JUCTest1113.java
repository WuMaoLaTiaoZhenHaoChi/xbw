package JUC.juc1113;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: 小霸王
 * @Date: 2019/11/13 9:47
 */
public class JUCTest1113 {

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        MyCAS cas = new MyCAS();
        for (int i = 0; i < 10; i++) {
            //new Thread(runnable).start();
            new Thread(new Runnable() {
            @Override
            public void run() {
                int exceptedValue = cas.getValue();
                System.out.println(cas.compareAndSet(exceptedValue, (int) (Math.random() * 10)));
            }
        }).start();
        }


    }

}

//模拟cas算法
class MyCAS{
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized int compareAndSwap(int exceptedValue, int newValue){
        int oldvalue = value;
        if (oldvalue == exceptedValue){
            value = newValue;
        }
        return oldvalue;
    }

    public synchronized boolean compareAndSet(int exceptedValue,int newValue){
        return  exceptedValue == compareAndSwap(exceptedValue,newValue);
    }

}

class MyRunnable implements Runnable{

    //private volatile int value = 1;
    private AtomicInteger value = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + ":" + getValue());
    }

    public int getValue(){
        //return this.value++;
        return value.getAndIncrement();
    }
}
