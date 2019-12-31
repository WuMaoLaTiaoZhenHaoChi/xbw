package duant.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: duant
 * @Date: 2019/12/31 10:39
 * 读写锁
 */
public class WiriteReadLockTest {

    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,String val){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 写入信息 key " + key);
            Thread.sleep(300);
            map.put(key, val);
            System.out.println(Thread.currentThread().getName() + " 写入完毕 " + val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 读出信息 key: " + key);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取完毕 " + result);
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        WiriteReadLockTest myTest = new WiriteReadLockTest();

        for (int i = 1; i <= 5; i++) {
            final int key = i;
            new Thread(() -> {
                myTest.put(key + "",key +"");
            }," Thread - " + i).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int key = i;
            new Thread(() -> {
                myTest.get(key + "");
            }," Thread - " + i).start();
        }


    }

}
