package duant.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: duant
 * @Date: 2020/01/08 9:20
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " execute ");
                });
            }
        }finally {
            threadPool.shutdown();
        }


    }

}
