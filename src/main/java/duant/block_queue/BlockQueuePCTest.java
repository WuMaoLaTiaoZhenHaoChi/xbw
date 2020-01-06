package duant.block_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: duant
 * @Date: 2020/01/06 11:17
 */
public class BlockQueuePCTest {


    public static void main(String[] args) {
        BlockQueuePC blockQueuePC = new BlockQueuePC(new ArrayBlockingQueue<String>(10));
        new Thread(() -> {
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            blockQueuePC.myProduce();
        }, " Produce ").start();

        new Thread(() -> {
            blockQueuePC.myConsume();
        }, " Consume ").start();

        try {
            Thread.sleep(5000);
            blockQueuePC.FLAG = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

class BlockQueuePC {
    public volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private BlockingQueue<String> blockingQueue = null;

    public BlockQueuePC(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myProduce() {
        String data;
        while (FLAG) {
            try {
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                data = atomicInteger.incrementAndGet() + "";
                boolean result = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (result) {
                    System.out.println(" produce 生产成功 data " + data);
                } else {
                    System.out.println(" produce 没生产 !!! ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" produce end !!! ");
    }

    public void myConsume() {
        String data;
        while (FLAG) {
            try {
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (!data.equalsIgnoreCase("") && data != null) {
                    System.out.println(" consume 获取到 data " + data);
                } else {
                    System.out.println(" consume 没取到data ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" consume end ");
    }
}

