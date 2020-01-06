package duant.block_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: duant
 * @Date: 2020/01/02 10:18
 */
public class BlokkQueueTest {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println("------------异常--------------");
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        System.out.println("-------------无异常-------------");
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

    }

}
