package JUC.juc1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 小霸王
 * @Date: 2019/11/15 9:34
 *
 * 循环打印
 */
public class JUC111501 {

    public static void main(String[] args) {
        MyABC myABC = new MyABC();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    myABC.printA(i);
                }
            }
        }," A ").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    myABC.printB(i);
                }
            }
        }," B ").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    myABC.printC(i);
                    System.out.println(" ---------------------- ");
                }
            }
        }," C ").start();
    }

}

class MyABC{

    private int stamp = 1;

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    //打印A
    public void printA(int time){
        lock.lock();
        try {
            if (stamp != 1){
                try {
                    conditionA.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " 第" + time +"次 " + " A ");
            stamp = 2;
            conditionB.signal();
        }finally {
            lock.unlock();
        }
    }

    //打印C
    public void printB(int time){
        lock.lock();
        try {
            if (stamp != 2){
                try {
                    conditionB.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " 第" + time +"次 " + " B ");
            stamp = 3;
            conditionC.signal();
        }finally {
            lock.unlock();
        }
    }
    //打印A
    public void printC(int time){
        lock.lock();
        try {
            if (stamp != 3){
                try {
                    conditionC.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " 第" + time +"次 " + " C ");
            stamp = 1;
            conditionA.signal();
        }finally {
            lock.unlock();
        }
    }
}
