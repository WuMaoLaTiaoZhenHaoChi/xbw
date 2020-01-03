package duant.block_queue;

import java.util.concurrent.SynchronousQueue;

/**
 * @Author: duant
 * @Date: 2020/01/03 16:04
 */
public class SynchronousQueueTest {

    SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

    public void put(){
        try {
            System.out.println("synchronousQueue.put(\"aaa\")");
            synchronousQueue.put("aaa");
            System.out.println("synchronousQueue.put(\"bbb\")");
            synchronousQueue.put("bbb");
            System.out.println("synchronousQueue.put(\"ccc\")");
            synchronousQueue.put("ccc");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void get(){
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        try {
            System.out.println(synchronousQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SynchronousQueueTest synchronousQueueTest = new SynchronousQueueTest();

        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                synchronousQueueTest.put();
            },"Thread - " + i).start();
        }

        for (int i = 0; i < 3; i++) {
           synchronousQueueTest.get();
        }


    }

}
