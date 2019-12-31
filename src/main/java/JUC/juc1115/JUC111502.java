package JUC.juc1115;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: 小霸王
 * @Date: 2019/11/15 10:04
 *
 * 读写锁
 */
public class JUC111502 {
    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    demo.setNum((int) (Math.random() * 10));
                }
            }
        }," Write ").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    demo.getNum();
                }
            }
        }," Read ").start();
    }

}

class ReadWriteLockDemo{
   private int num;
   private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

   public void getNum(){
       readWriteLock.readLock().lock();
       try {
           System.out.println(Thread.currentThread().getName() + " getNum: " + num);
       } finally {
           readWriteLock.readLock().unlock();
       }

   }

   public void setNum(int num){
       readWriteLock.writeLock().lock();
       try {
           this.num = num;
           System.out.println(" setNum: " + num);
       } finally {
           readWriteLock.writeLock().unlock();
       }
   }


}
