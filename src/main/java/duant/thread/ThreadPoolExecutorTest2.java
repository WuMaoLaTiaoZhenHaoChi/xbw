package duant.thread;

import java.util.concurrent.*;

/**
 * @Author: duant
 * @Date: 2020/1/9 22:11
 * 自定义线程池
 */
public class ThreadPoolExecutorTest2 {

    public static void main(String[] args) {

        MyThread thread = new MyThread();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,
                5, 5L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            for (int i = 01; i <= 10; i++) {
                poolExecutor.execute(thread);
            }
        }finally {
            poolExecutor.shutdown();
        }

    }

}

class MyThread implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 处理业务 ");
    }

}
